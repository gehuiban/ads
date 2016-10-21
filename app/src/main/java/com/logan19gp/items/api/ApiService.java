package com.logan19gp.items.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("getAds")
    Call<Ads> getAds(
            @Query("id") Integer id,
            @Query("password") String password,
            @Query("siteId") Integer siteId,
            @Query("deviceId") String deviceId,
            @Query("sessionId") String sessionId,
            @Query("totalCampaignsRequested") Integer totalCampaignsRequested,
            @Query("lname") String lname
    );
}
