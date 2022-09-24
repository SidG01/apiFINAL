package com.example.f1apiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Simulation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);
    }

    public void back(View view) {

        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

    }
}