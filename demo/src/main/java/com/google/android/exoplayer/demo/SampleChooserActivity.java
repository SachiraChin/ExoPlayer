/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.android.exoplayer.demo;

import com.google.android.exoplayer.MediaCodecUtil;
import com.google.android.exoplayer.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer.demo.Samples.Sample;
import com.google.android.exoplayer.demo.models.AutoDiscoverResponse;
import com.google.android.exoplayer.demo.models.ChannelsResponse;
import com.google.android.exoplayer.demo.models.ChannelsValue;
import com.google.android.exoplayer.demo.models.DashTokenResponse;
import com.google.android.exoplayer.demo.models.DashVideoResponse;
import com.google.android.exoplayer.demo.models.HlsVideoResponse;
import com.google.android.exoplayer.demo.models.VideosResponse;
import com.google.android.exoplayer.demo.models.VideosValue;
import com.google.android.exoplayer.util.MimeTypes;
import com.microsoft.aad.adal.AuthenticationCallback;
import com.microsoft.aad.adal.AuthenticationContext;
import com.microsoft.aad.adal.AuthenticationException;
import com.microsoft.aad.adal.AuthenticationResult;
import com.microsoft.aad.adal.PromptBehavior;
import com.squareup.okhttp.ResponseBody;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * An activity for selecting from a number of samples.
 */
public class SampleChooserActivity extends Activity {

  private static final String TAG = "SampleChooserActivity";

  private AuthenticationContext mContext;

  private static String TenantId = "d868be21-6345-401b-8132-c3979c554e2a";
  private static String ClientId = "bac6e04a-b5f4-464b-af3f-623577e14043";
  private static String ReturnUri = "http://occulemvideos";

  private static String Authority = "https://login.windows.net/" + TenantId;
  private String SharePointUrl = "https://occulem.sharepoint.com/";
  private AuthenticationResult mResult;
  // Activity lifecycle
  private AuthenticationCallback<AuthenticationResult> callback = new AuthenticationCallback<AuthenticationResult>() {

    @Override
    public void onError(Exception exc) {
      if (exc instanceof AuthenticationException) {
        //textViewStatus.setText("Cancelled");
        Log.d(TAG, "Cancelled");
      } else {
        //textViewStatus.setText("Authentication error:" + exc.getMessage());
        Log.d(TAG, "Authentication error:" + exc.getMessage());
      }
    }

    @Override
    public void onSuccess(AuthenticationResult result) {
      mResult = result;

      if (result == null || result.getAccessToken() == null
              || result.getAccessToken().isEmpty()) {
        //textViewStatus.setText("Token is empty");
        Log.d(TAG, "Token is empty");
      } else {
        // request is successful
        Log.d(TAG, "Status:" + result.getStatus() + " Expired:"
                + result.getExpiresOn().toString());
        final String token = result.getAccessToken();

        Thread thread = new Thread(new Runnable(){
          @Override
          public void run() {
            try {
              //Your code goes here

              Retrofit retrofit = new Retrofit.Builder()
                      .baseUrl("https://occulem.sharepoint.com")
                      .addConverterFactory( GsonConverterFactory.create())
                      .build();

              DiscoverService service = retrofit.create(DiscoverService.class);
              try {
                //AutoDiscoverResponse res = service.VideoServiceDiscover("Bearer " + token).execute().body();

                //Log.d(TAG, "portal: " + res.getVideoPortalUrl());

                VideoApiService videoApiService = retrofit.create(VideoApiService.class);
                ChannelsResponse channels = videoApiService.Channels("Bearer " + token).execute().body();
                //String err= videoApiService.Channels("Bearer " + token).execute().errorBody().string();

                ChannelsValue firstChannel = channels.getValue().get(0);
                //Log.d(TAG, "err: " +err);
                Log.d(TAG, "cid: " +firstChannel.getId());

                VideosResponse videos = videoApiService.Videos("Bearer " + token, firstChannel.getId()).execute().body();
                VideosValue firstVideo = videos.getValue().get(0);
                Log.d(TAG, "vid: " +firstVideo.getID());

                DashVideoResponse dash = videoApiService.Video("Bearer " + token, firstChannel.getId(), firstVideo.getID(), 0).execute().body();
                Log.d(TAG, "dash: " +dash.getValue());

                //TokenApiService tokenApiService = retrofit.create(TokenApiService.class);
                //Response err  = videoApiService.VideoDashToken("Bearer " + token, firstChannel.getId(), firstVideo.getID()).execute();
                DashTokenResponse dashtoken = videoApiService.VideoDashToken("Bearer " + token, firstChannel.getId(), firstVideo.getID()).execute().body();
                Log.d(TAG, "dashtoken: " +dashtoken.getValue());


                final String vname = firstVideo.getTitle();
                final String vurl = dash.getValue();
                final String tokend = dashtoken.getValue();

                Runnable myRunnable = new Runnable() {
                  @Override
                  public void run() {

                    ListView sampleList = (ListView) findViewById(R.id.sample_list);
                    final SampleAdapter sampleAdapter = new SampleAdapter(SampleChooserActivity.this);

                    sampleAdapter.add(new Header("SharePoint"));
                    sampleAdapter.addAll((Object[]) new Sample[]{
                            new Sample(vname,vurl, PlayerActivity.TYPE_HLS, token),
                            new Sample("Apple master playlist",
                                    "https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/"
                                            + "bipbop_4x3_variant.m3u8", PlayerActivity.TYPE_HLS),
                            new Sample("Apple master playlist advanced",
                                    "https://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/"
                                            + "bipbop_16x9_variant.m3u8", PlayerActivity.TYPE_HLS)
                    });

                    sampleList.setAdapter(sampleAdapter);
                    sampleList.setOnItemClickListener(new OnItemClickListener() {
                      @Override
                      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Object item = sampleAdapter.getItem(position);
                        if (item instanceof Sample) {
                          onSampleSelected((Sample) item);
                        }
                      }
                    });

                  } // This is your code
                };
                Handler mainHandler = new Handler(SampleChooserActivity.this.getMainLooper());
                mainHandler.post(myRunnable);
              } catch (IOException e) {
                e.printStackTrace();
              }
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        });

        thread.start();

        //textViewStatus.setText(PASSED);
      }
    }
  };

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (mContext != null) {
      mContext.onActivityResult(requestCode, resultCode, data);
    }
  }
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sample_chooser_activity);

    try {
      mContext = new AuthenticationContext(SampleChooserActivity.this, Authority, true); // This will use SharedPreferences as            default cache
      mContext.acquireToken(SampleChooserActivity.this, SharePointUrl, ClientId, ReturnUri, "sachira@occulem.com", PromptBehavior.Auto, "",
              callback);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (NoSuchPaddingException e) {
      e.printStackTrace();
    }

  }

  private void onSampleSelected(Sample sample) {
    Intent mpdIntent = new Intent(this, PlayerActivity.class)
        .setData(Uri.parse(sample.uri))
        .putExtra(PlayerActivity.CONTENT_ID_EXTRA, sample.contentId)
        .putExtra(PlayerActivity.CONTENT_TYPE_EXTRA, sample.type)
        .putExtra(PlayerActivity.PROVIDER_EXTRA, sample.provider)
        .putExtra(PlayerActivity.TOKEN, sample.token);
    startActivity(mpdIntent);
  }

  private static class SampleAdapter extends ArrayAdapter<Object> {

    public SampleAdapter(Context context) {
      super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View view = convertView;
      if (view == null) {
        int layoutId = getItemViewType(position) == 1 ? android.R.layout.simple_list_item_1
            : R.layout.sample_chooser_inline_header;
        view = LayoutInflater.from(getContext()).inflate(layoutId, null, false);
      }
      Object item = getItem(position);
      String name = null;
      if (item instanceof Sample) {
        name = ((Sample) item).name;
      } else if (item instanceof Header) {
        name = ((Header) item).name;
      }
      ((TextView) view).setText(name);
      return view;
    }

    @Override
    public int getItemViewType(int position) {
      return (getItem(position) instanceof Sample) ? 1 : 0;
    }

    @Override
    public int getViewTypeCount() {
      return 2;
    }

  }

  private static class Header {

    public final String name;

    public Header(String name) {
      this.name = name;
    }

  }

}
