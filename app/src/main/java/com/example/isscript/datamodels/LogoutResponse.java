package com.example.isscript.datamodels;

import com.google.gson.annotations.SerializedName;

public class LogoutResponse{

	@SerializedName("message")
	private String message;

	public String getMessage(){
		return message;
	}
}