package com.u1803005.D2.api;

import com.u1803005.D2.api.models.RSDP;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface BungieAPI {

    String baseUrl = "https://www.bungie.net/";
    @Headers("X-API-KEY: ")
    @GET("Platform/Destiny2/SearchDestinyPlayer/-1/RevoltOfTheAtoms")
    Call<RSDP> searchPlayer();

}