package com.example.isscript.api;

import com.google.gson.annotations.SerializedName;

public class Authorisation{

	@SerializedName("type")
	private String type;

	@SerializedName("token")
	private String token;

	public String getType(){
		return type;
	}

	public String getToken(){
		return token;
	}
}