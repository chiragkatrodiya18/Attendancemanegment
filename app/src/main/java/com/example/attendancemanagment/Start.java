package com.example.attendancemanagment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import java.sql.Time;
import android.os.Handler;

public class Start extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        sharedpreferences = getSharedPreferences("Am", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                if (!sharedpreferences.getString("Id","").isEmpty()){
                    startActivity(new Intent(Start.this, MainActivity.class));
                }
                else{
                    startActivity(new Intent(Start.this, LoginActivity.class));
                }
            }
        };
        Handler h = new Handler();
        h.postDelayed(r, 2500);
    }
}
