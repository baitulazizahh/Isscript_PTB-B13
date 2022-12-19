package com.example.isscript.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("api/login/")
    Call<LoginResponse> userlogin(@Body LoginRequest loginRequest);
}
