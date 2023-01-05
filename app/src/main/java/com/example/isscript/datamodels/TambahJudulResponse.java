package com.example.isscript.datamodels;

import com.google.gson.annotations.SerializedName;

public class TambahJudulResponse{

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}
}