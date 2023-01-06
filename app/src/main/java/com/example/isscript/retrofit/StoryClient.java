package com.example.isscript.retrofit;

import androidx.annotation.Nullable;

import com.example.isscript.datamodels.DetailSemhas2Response;
import com.example.isscript.datamodels.DetailTAResponse;
import com.example.isscript.datamodels.GantipwResponse;
import com.example.isscript.datamodels.ListLogbookResponse;
import com.example.isscript.datamodels.LoginResponse;
import com.example.isscript.datamodels.LogoutResponse;
import com.example.isscript.datamodels.PembimbingResponse;
import com.example.isscript.datamodels.PilihPembimbingResponse;
import com.example.isscript.datamodels.ProfilResponse;
import com.example.isscript.datamodels.ReviewersItem;

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


    @GET("/api/theses/309/seminars")
    Call<DetailSemhas2Response> detailSemhas(
            @Header("Authorization")String token
    );

    @GET("/api/theses/309/seminars")
    Call<ReviewersItem> reviewers (
            @Header("Authorization")String token
    );

    @GET("api/theses/309/logbooks")
    Call<ListLogbookResponse> getlistLB(
            @Header("Authorization")String token);

    @GET("/api/theses/277/trials")
    Call<DetailTAResponse> detailta(
            @Header("Authorization")String token
    );
/*
    @FormUrlEncoded
    @POST("/api/thesis/seminars/322/audiences")
    Call<PilihPembimbingResponse> PilihPbb(
            @Field("lecturer_id") String lecturer_id,
            @Header("Authorization") String token
    );*/

    @FormUrlEncoded
    @POST("/api/theses")
    Call<PembimbingResponse> pilihpembimbing(
            @Field("title") String title,
            @Field("abstract") String abstracts,
            @Field("lecturer_id") String lecturer_id,
            @Field("position") String position,
            @Header("Authorization") String token
    );
}
