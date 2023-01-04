package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isscript.datamodels.GantipwResponse;
import com.example.isscript.datamodels.TambahLogbookResponse;
import com.example.isscript.retrofit.StoryClient;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class c1_tambah_logbook extends AppCompatActivity {
    EditText tiettgl, tiet4, tiet5,tietid;
    Button simpan;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1_tambah_logbook);
        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");
//        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
//        token = sharedPref.getString("TOKEN", "");
        tietid = findViewById(R.id.textInputEditText4);
        tiettgl = findViewById(R.id.textInputEditTextid);
        tiet4 = findViewById(R.id.textInputproblem);
        tiet5 = findViewById(R.id.textInputEditText5);

        simpan= findViewById(R.id.button);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmbhLogbook();
            }
        });
    }

    private void tmbhLogbook() {
//        tiettgl = findViewById(R.id.textInputEditText4);
//        tiet4 = findViewById(R.id.textInputproblem);
//        tiet5 = findViewById(R.id.textInputEditText5);
//        tietid = findViewById(R.id.textInputEditTextid);
//        btn_tmbhlogbook = findViewById(R.id.button);

        String supervisor_id =  tietid.getText().toString();
        String date = tiettgl.getText().toString();
        String progress = tiet4.getText().toString();
        String problem = tiet5.getText().toString();

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
        StoryClient client = retrofit.create(StoryClient.class);

        Call<TambahLogbookResponse> call = client.tmbhlogbook("Bearer "+token,supervisor_id,date,progress,problem);
        call.enqueue(new Callback<TambahLogbookResponse>() {
            @Override
            public void onResponse(Call<TambahLogbookResponse> call, Response<TambahLogbookResponse> response) {
                Log.d("debug-act", response.toString());
                if (response.isSuccessful()) {
                    TambahLogbookResponse tambahLogbookResponse = response.body();
                    if (tambahLogbookResponse != null && tambahLogbookResponse.getMessage()== "success") {
                            Toast.makeText(c1_tambah_logbook.this, tambahLogbookResponse.getMessage(), Toast.LENGTH_SHORT).show();

                                SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
                                SharedPreferences.Editor editor= sharedPref.edit();
                                editor.apply();

                        Intent Intent = new Intent(c1_tambah_logbook.this,a2_homescreen.class);
                        startActivity(Intent);
                       }
                    } else {
                            Toast.makeText(c1_tambah_logbook.this, "Gagal menambah logbook", Toast.LENGTH_SHORT).show();
                        }
            }
            @Override
            public void onFailure(Call<TambahLogbookResponse> call, Throwable t) {
                Toast.makeText(c1_tambah_logbook.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
            }
        });
    }
    public void simpan (View view) {
        Intent intent = new Intent(c1_tambah_logbook.this, a2_homescreen.class);
        startActivity(intent);
    }
//    public void c1kehomescreen(View view) {
//        Intent intent = new Intent(c1_tambah_logbook.this, a2_homescreen.class);
//        startActivity(intent);
//    }
//
//    public void btnc1kehomescreen2(View view) {
//        Intent intent = new Intent(c1_tambah_logbook.this, a2_homescreen.class);
//        startActivity(intent);
//    }
}