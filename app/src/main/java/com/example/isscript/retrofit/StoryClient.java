package com.example.isscript.retrofit;

import com.example.isscript.datamodels.GantipwResponse;
import com.example.isscript.datamodels.LoginResponse;
import com.example.isscript.datamodels.ProfilResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface StoryClient {

    @FormUrlEncoded
    @POST("/api/login")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);

    @GET("api/me")
    Call<ProfilResponse> profill(@Header("Authorization")String token);

    /*@FormUrlEncoded
    @POST("/api/password")
    Call<GantipwResponse> gantii(@Field("username") String username, @Field("password") String password);*/

}
