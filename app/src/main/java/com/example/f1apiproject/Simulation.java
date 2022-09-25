package com.example.f1apiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Simulation extends AppCompatActivity {
    SImAPICall L1, L2, L3, L4, L5, L6,  L7, L8,  L9, L10;
    TextView resultsTextView;
    ProgressDialog progressDialog;
    Button displayData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);
        resultsTextView = (TextView) findViewById(R.id.results);
        displayData = (Button) findViewById(R.id.displayData);

        L1 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/1.json");
        L2 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/2.json");
        L3 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/3.json");
        L4 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/4.json");
        L5 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/5.json");
        L6 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/6.json");
        L7 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/7.json");
        L8 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/8.json");
        L9 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/9.json");
        L10 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/10.json");
    }

    public void back(View view) {
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }


    public void run(View view) {

    }


}