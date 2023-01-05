package com.example.isscript.retrofit;

import androidx.annotation.Nullable;

import com.example.isscript.datamodels.AudiencesItem;
import com.example.isscript.datamodels.DetailSidangResponse;
import com.example.isscript.datamodels.DetailSidanggResponse;
import com.example.isscript.datamodels.DetailTAResponse;
import com.example.isscript.datamodels.ExaminersItem;
import com.example.isscript.datamodels.GantipwResponse;
import com.example.isscript.datamodels.InputPesertaResponse;
import com.example.isscript.datamodels.ListPesertaResponse;
import com.example.isscript.datamodels.ListResponse;
import com.example.isscript.datamodels.LoginResponse;
import com.example.isscript.datamodels.LogoutResponse;
import com.example.isscript.datamodels.ProfilResponse;
import com.example.isscript.datamodels.Student;
import com.example.isscript.datamodels.SupervisorsItem;
import com.example.isscript.datamodels.TambahJudulResponse;

import java.util.List;

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

    @GET("/api/theses/277/trials")
    Call<DetailSidanggResponse> detailSidang(
            @Header("Authorization")String token
    );

/*    @GET("/api/theses/309")
    Call<Student> student(
            @Header("Authorization")String token
    );*/

    @GET("/api/theses/309")
    Call<SupervisorsItem> supervisor(
            @Header("Authorization")String token
    );

/*    @GET("/api/theses/277/trials")
    Call<ExaminersItem> examiner(
            @Header("Authorization")String token
    );*/

    @GET("/api/theses/309")
    Call<DetailTAResponse> detailta(
            @Header("Authorization")String token
    );

    @FormUrlEncoded
    @POST("/api/theses")
    Call<TambahJudulResponse> tambahjdl(
            @Field("title") String title,
            @Field("abstract") String abstracts,
            @Field("lecturer_id") String lecturer_id,
            @Field("position") String position,
            @Header("Authorization") String token
    );

    @FormUrlEncoded
    @POST("/api/thesis/seminars/322/audiences")
    Call<InputPesertaResponse> inputt(
            @Field("student_id") String student_id,
            @Header("Authorization") String token
    );

    @GET("/api/thesis/seminars/322/audiences")
    Call <ListResponse> listaud(
            @Header("Authorization") String token
    );
}
