package com.example.isscript.datamodels;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

    @SerializedName("authorisation")
    private com.example.isscript.datamodels.Authorisation authorisation;

    @SerializedName("user")
    private User user;

    @SerializedName("status")
    private String status;

    public com.example.isscript.datamodels.Authorisation getAuthorisation(){
        return authorisation;
    }

    public User getUser(){
        return user;
    }

    public String getStatus(){
        return status;
    }
}