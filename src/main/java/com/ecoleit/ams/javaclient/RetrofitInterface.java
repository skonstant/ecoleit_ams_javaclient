package com.ecoleit.ams.javaclient;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("greeting")
    Call<Greeting> getGreeting(@Query("name") String name);

}
