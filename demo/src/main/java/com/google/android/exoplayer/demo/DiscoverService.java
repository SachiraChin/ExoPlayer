package com.google.android.exoplayer.demo;

import com.google.android.exoplayer.demo.models.AutoDiscoverResponse;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by Sachir on 11/12/2015.
 */
public interface DiscoverService {
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("/_api/VideoService.Discover")
    Call<AutoDiscoverResponse> VideoServiceDiscover(@Header("Authorization") String authorization);
}
