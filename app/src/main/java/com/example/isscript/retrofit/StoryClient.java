package com.example.isscript.retrofit;

import androidx.annotation.Nullable;

import com.example.isscript.datamodels.GantipwResponse;
import com.example.isscript.datamodels.LoginResponse;
import com.example.isscript.datamodels.LogoutResponse;
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
    Call<LoginResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @POST("/api/logout")
    Call<LogoutResponse> logout(
            @Header("Authorization") String token
    );

    @GET("/api/me")
    Call<ProfilResponse> profill(
            @Header("Authorization")String token
    );

    @FormUrlEncoded
    @POST("/api/password")
    Call<GantipwResponse> gantii(
            @Field("old_password") String old_password,
            @Field("new_password") String new_password,
            @Field("confirm_password") String confirm_password,
            @Header("Authorization") String token
    );

}
