package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.isscript.api.ApiClient;
import com.example.isscript.api.Authorisation;
import com.example.isscript.api.LoginRequest;
import com.example.isscript.api.LoginResponse;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class a1_login extends AppCompatActivity {

    EditText username, password;
    Button buttonlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1_login);

        username = findViewById(R.id.idusername);
        password = findViewById(R.id.idpassword);
        buttonlogin = findViewById(R.id.idbuttonlogin);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText().toString())||TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(a1_login.this, "Username / Password Required", Toast.LENGTH_LONG).show();
                } else{
                    login();

                }

            }
        });
    }

    public void login(){

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userlogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(a1_login.this, "Berhasil login", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                           /* startActivity(new Intent(a1_login.this, a2_homescreen.class).putExtra("data", loginResponse.getUsername()));*/
                            Response response1 = Response.get();
                            String token = response1.getToken();

                            SharedPreferences sharedPref = getSharedPreferences(
                                    "com.example.isscript",
                                    MODE_PRIVATE);

                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("TOKEN", token);
                            editor.apply();

                            Toast.makeText(a1_login.this, "Berhasil login", Toast.LENGTH_SHORT).show();
                            Intent mainIntent = new Intent(a1_login.this, a2_homescreen.class);
                            mainIntent.putExtra("USERX", (Serializable) username);
                            mainIntent.putExtra("LOGX", true);
                            startActivity(mainIntent);
                        }
                    },700);
                }else {
                    Toast.makeText(a1_login.this, "Gagal Login", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(a1_login.this, "Throwable "+ t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}