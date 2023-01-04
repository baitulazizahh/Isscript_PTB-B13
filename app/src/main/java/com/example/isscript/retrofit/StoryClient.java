package com.example.isscript.retrofit;

import android.widget.EditText;

import com.example.isscript.datamodels.DetailLogbookResponse;
import com.example.isscript.datamodels.GantipwResponse;
import com.example.isscript.datamodels.LoginResponse;
import com.example.isscript.datamodels.LogoutResponse;
import com.example.isscript.datamodels.ProfilResponse;
import com.example.isscript.datamodels.RvhsResponse;
import com.example.isscript.datamodels.TambahLogbookResponse;

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

    @FormUrlEncoded
    @POST("/api/theses/301/logbooks")
    Call<TambahLogbookResponse> tmbhlogbook(
            @Header("Authorization") String token,
            @Field("supervisor_id") String supervisor_id,
            @Field("date") String date,
            @Field("progress") String progress,
            @Field("problem") String problem
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

    @GET("/api/theses/200/logbooks/399")
    Call<DetailLogbookResponse> detaillb(
            @Header("Authorization")String token
    );


    @GET("/api/thesis/seminars/322/audiences")
    Call<RvhsResponse> rvhs(
            @Header("Authorization")String token
    );

}
