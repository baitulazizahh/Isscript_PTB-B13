package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.isscript.api.StoryEndpoint;

public class a1_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1_login);
    }
    public void a1masuk(View view) {
        Intent intent = new Intent(a1_login.this, a2_homescreen.class);
        startActivity(intent);
    }

    /*public void onLoginButtonClicked (View view) {

        String BASE_URL="http://ptb-api.husnilkamil.my.id/";

        username = binding.textEditUsername.getText().toString();
        password = binding.textEditPassword.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        StoryEndpoint client = retrofit.create(StoryEndpoint.class);

        Call <LoginResponse> call = client.loginToServer(username, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse (Call<LoginResponse> call, Response <LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (!loginResponse.isError()){
                    LoginResult loginResult = loginResponse.getLoginResult();
                    String token = loginResult.getToken();

                    SharedPreferences sharedPref = getSharedPreferences(
                            "com.example.isscript",
                            MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("TOKEN", token);
                    editor.apply();

                    Toast.makeText(LoginActivity.this, "Berhasil login", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(a1_login.this, a2_homescreen.class);
                    mainIntent.putExtra("USERX", username);
                    mainIntent.putExtra("LOGX", true);
                    startActivity(mainIntent);

                } else {
                    Toast.makeText(a1_login.this, "Gagal Login", Toast.LENGTH_SHORT).show();
                }*/
}