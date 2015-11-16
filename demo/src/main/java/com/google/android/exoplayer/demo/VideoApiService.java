package com.google.android.exoplayer.demo;

import com.google.android.exoplayer.demo.models.AutoDiscoverResponse;
import com.google.android.exoplayer.demo.models.ChannelsResponse;
import com.google.android.exoplayer.demo.models.DashTokenResponse;
import com.google.android.exoplayer.demo.models.DashVideoResponse;
import com.google.android.exoplayer.demo.models.HlsVideoResponse;
import com.google.android.exoplayer.demo.models.VideosResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by Sachir on 11/12/2015.
 */
public interface VideoApiService {
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("/portals/hub/_api/VideoService/Channels")
    Call<ChannelsResponse> Channels(@Header("Authorization") String authorization);

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("/portals/hub/_api/VideoService/Channels(guid'{cid}')/Videos")
    Call<VideosResponse> Videos(@Header("Authorization") String authorization,@Path("cid") String cid );

    //@GET("/portals/hub/_api/VideoService/Channels(guid'{cid}')/Videos(guid'{vid}')/GetPlaybackUrl(0)")
    //Call<HlsVideoResponse> VideoHls(@Header("Authorization") String authorization,@Path("cid") String cid,@Path("vid") String vid );

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("/portals/hub/_api/VideoService/Channels('{cid}')/Videos('{vid}')/GetPlaybackUrl('{type}')")
    Call<DashVideoResponse> Video(@Header("Authorization") String authorization,@Path("cid") String cid,@Path("vid") String vid, @Path("type")int type);

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("/portals/hub/_api/VideoService/Channels('{cid}')/Videos('{vid}')/GetStreamingKeyAccessToken")
    Call<DashTokenResponse> VideoDashToken(@Header("Authorization") String authorization,@Path("cid") String cid,@Path("vid") String vid );
}
