package com.example.isscript.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface StoryEndpoint {

    @POST("v1/login")
    Call<LoginResponse> loginToServer(
            @Field("username") String username,
            @Field("password") String password
    );

}
