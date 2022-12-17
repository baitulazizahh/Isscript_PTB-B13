package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.isscript.api.LoginResponse;
import com.example.isscript.api.StoryEndpoint;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class a1_login extends AppCompatActivity {

    EditText editUsername, editPassword;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1_login);
    }
    public void a1masuk(View view) {
        Intent intent = new Intent(a1_login.this, a2_homescreen.class);
        startActivity(intent);
    }

    public void onLoginButtonClicked (View view) {

        String BASE_URL="http://ptb-api.husnilkamil.my.id/";
        editUsername = findViewById(R.id.textEditUsername);
        editPassword = findViewById(R.id.textEditPassword);

        username = editUsername.getText().toString();
        password = editPassword.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        StoryEndpoint client = retrofit.create(StoryEndpoint.class);

        Call<LoginResponse> call = client.loginToServer(username, password);
        call.enqueue(new Callback <LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (!loginResponse.isError()) {
                    LoginResult loginResult = loginResponse.getLoginResult();
                    String token = loginResult.getToken();

                    SharedPreferences sharedPref = getSharedPreferences(
                            "com.example.isscript",
                            MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("TOKEN", token);
                    editor.apply();

                    Toast.makeText(a1_login.this, "Berhasil login", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(a1_login.this, a2_homescreen.class);
                    mainIntent.putExtra("USERX", username);
                    mainIntent.putExtra("LOGX", true);
                    startActivity(mainIntent);

                } else {
                    Toast.makeText(a1_login.this, "Gagal Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}