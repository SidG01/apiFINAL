package com.example.f1apiproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Simulation extends AppCompatActivity {

    SImAPICall L1, L2, L3, L4, L5, L6,  L7, L8,  L9, L10;
    SImAPICall L11, L12, L13, L14, L15, L16,  L17, L18,  L19, L20;
    SImAPICall L21, L22, L23, L24, L25, L26,  L27, L28,  L29, L30;
    SImAPICall L31, L32, L33, L34, L35, L36,  L37, L38,  L39, L40;
    SImAPICall L41, L42, L43, L44, L45, L46,  L47, L48,  L49, L50;
    SImAPICall L51, L52, L53, L54, L55;

    TextView resultsTextView;
    ProgressDialog progressDialog;
    Button displayData;

    ArrayList<Double> dataSimApi = new ArrayList<>();
    ArrayList<String> dataSimApiNames = new ArrayList<>();


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

        L11 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/11.json");
        L12 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/12.json");
        L13 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/13.json");
        L14 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/14.json");
        L15 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/15.json");
        L16 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/16.json");
        L17 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/17.json");
        L18 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/18.json");
        L19 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/19.json");
        L20 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/20.json");

        L21 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/21.json");
        L22 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/22.json");
        L23 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/23.json");
        L24 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/24.json");
        L25 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/25.json");
        L26 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/26.json");
        L27 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/27.json");
        L28 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/28.json");
        L29 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/29.json");
        L30 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/30.json");

        L31 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/31.json");
        L32 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/32.json");
        L33 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/33.json");
        L34 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/34.json");
        L35 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/35.json");
        L36 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/36.json");
        L37 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/37.json");
        L38 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/38.json");
        L39 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/39.json");
        L40 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/40.json");

        L41 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/41.json");
        L42 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/42.json");
        L43 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/43.json");
        L44 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/44.json");
        L45 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/45.json");
        L46 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/46.json");
        L47 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/47.json");
        L48 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/48.json");
        L49 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/49.json");
        L50 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/50.json");

        L51 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/51.json");
        L52 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/52.json");
        L53 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/53.json");
        L54 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/54.json");
        L55 = new SImAPICall("https://ergast.com/api/f1/2021/1/laps/55.json");

    }

    public void back(View view) {
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void run(View view) {

        dataSimApi.addAll(L1.DriverTimeDOUBLE);
        dataSimApi.addAll(L2.DriverTimeDOUBLE);
        dataSimApi.addAll(L3.DriverTimeDOUBLE);
        dataSimApi.addAll(L4.DriverTimeDOUBLE);
        dataSimApi.addAll(L5.DriverTimeDOUBLE);
        dataSimApi.addAll(L6.DriverTimeDOUBLE);
        dataSimApi.addAll(L7.DriverTimeDOUBLE);
        dataSimApi.addAll(L8.DriverTimeDOUBLE);
        dataSimApi.addAll(L9.DriverTimeDOUBLE);
        dataSimApi.addAll(L10.DriverTimeDOUBLE);

        dataSimApi.addAll(L11.DriverTimeDOUBLE);
        dataSimApi.addAll(L12.DriverTimeDOUBLE);
        dataSimApi.addAll(L13.DriverTimeDOUBLE);
        dataSimApi.addAll(L14.DriverTimeDOUBLE);
        dataSimApi.addAll(L15.DriverTimeDOUBLE);
        dataSimApi.addAll(L16.DriverTimeDOUBLE);
        dataSimApi.addAll(L17.DriverTimeDOUBLE);
        dataSimApi.addAll(L18.DriverTimeDOUBLE);
        dataSimApi.addAll(L19.DriverTimeDOUBLE);
        dataSimApi.addAll(L20.DriverTimeDOUBLE);

        dataSimApi.addAll(L21.DriverTimeDOUBLE);
        dataSimApi.addAll(L22.DriverTimeDOUBLE);
        dataSimApi.addAll(L23.DriverTimeDOUBLE);
        dataSimApi.addAll(L24.DriverTimeDOUBLE);
        dataSimApi.addAll(L25.DriverTimeDOUBLE);
        dataSimApi.addAll(L26.DriverTimeDOUBLE);
        dataSimApi.addAll(L27.DriverTimeDOUBLE);
        dataSimApi.addAll(L28.DriverTimeDOUBLE);
        dataSimApi.addAll(L29.DriverTimeDOUBLE);
        dataSimApi.addAll(L30.DriverTimeDOUBLE);

        dataSimApi.addAll(L31.DriverTimeDOUBLE);
        dataSimApi.addAll(L32.DriverTimeDOUBLE);
        dataSimApi.addAll(L33.DriverTimeDOUBLE);
        dataSimApi.addAll(L34.DriverTimeDOUBLE);
        dataSimApi.addAll(L35.DriverTimeDOUBLE);
        dataSimApi.addAll(L36.DriverTimeDOUBLE);
        dataSimApi.addAll(L37.DriverTimeDOUBLE);
        dataSimApi.addAll(L38.DriverTimeDOUBLE);
        dataSimApi.addAll(L39.DriverTimeDOUBLE);
        dataSimApi.addAll(L40.DriverTimeDOUBLE);

        dataSimApi.addAll(L41.DriverTimeDOUBLE);
        dataSimApi.addAll(L42.DriverTimeDOUBLE);
        dataSimApi.addAll(L43.DriverTimeDOUBLE);
        dataSimApi.addAll(L44.DriverTimeDOUBLE);
        dataSimApi.addAll(L45.DriverTimeDOUBLE);
        dataSimApi.addAll(L46.DriverTimeDOUBLE);
        dataSimApi.addAll(L47.DriverTimeDOUBLE);
        dataSimApi.addAll(L48.DriverTimeDOUBLE);
        dataSimApi.addAll(L49.DriverTimeDOUBLE);
        dataSimApi.addAll(L50.DriverTimeDOUBLE);

        dataSimApi.addAll(L51.DriverTimeDOUBLE);
        dataSimApi.addAll(L52.DriverTimeDOUBLE);
        dataSimApi.addAll(L53.DriverTimeDOUBLE);
        dataSimApi.addAll(L54.DriverTimeDOUBLE);
        dataSimApi.addAll(L55.DriverTimeDOUBLE);

        dataSimApiNames.addAll(L1.DriverNames);
        dataSimApiNames.addAll(L2.DriverNames);
        dataSimApiNames.addAll(L3.DriverNames);
        dataSimApiNames.addAll(L4.DriverNames);
        dataSimApiNames.addAll(L5.DriverNames);
        dataSimApiNames.addAll(L6.DriverNames);
        dataSimApiNames.addAll(L7.DriverNames);
        dataSimApiNames.addAll(L8.DriverNames);
        dataSimApiNames.addAll(L9.DriverNames);
        dataSimApiNames.addAll(L10.DriverNames);

        dataSimApiNames.addAll(L11.DriverNames);
        dataSimApiNames.addAll(L12.DriverNames);
        dataSimApiNames.addAll(L13.DriverNames);
        dataSimApiNames.addAll(L14.DriverNames);
        dataSimApiNames.addAll(L15.DriverNames);
        dataSimApiNames.addAll(L16.DriverNames);
        dataSimApiNames.addAll(L17.DriverNames);
        dataSimApiNames.addAll(L18.DriverNames);
        dataSimApiNames.addAll(L19.DriverNames);
        dataSimApiNames.addAll(L20.DriverNames);

        dataSimApiNames.addAll(L21.DriverNames);
        dataSimApiNames.addAll(L22.DriverNames);
        dataSimApiNames.addAll(L23.DriverNames);
        dataSimApiNames.addAll(L24.DriverNames);
        dataSimApiNames.addAll(L25.DriverNames);
        dataSimApiNames.addAll(L26.DriverNames);
        dataSimApiNames.addAll(L27.DriverNames);
        dataSimApiNames.addAll(L28.DriverNames);
        dataSimApiNames.addAll(L29.DriverNames);
        dataSimApiNames.addAll(L30.DriverNames);

        dataSimApiNames.addAll(L31.DriverNames);
        dataSimApiNames.addAll(L32.DriverNames);
        dataSimApiNames.addAll(L33.DriverNames);
        dataSimApiNames.addAll(L34.DriverNames);
        dataSimApiNames.addAll(L35.DriverNames);
        dataSimApiNames.addAll(L36.DriverNames);
        dataSimApiNames.addAll(L37.DriverNames);
        dataSimApiNames.addAll(L38.DriverNames);
        dataSimApiNames.addAll(L39.DriverNames);
        dataSimApiNames.addAll(L40.DriverNames);

        dataSimApiNames.addAll(L41.DriverNames);
        dataSimApiNames.addAll(L42.DriverNames);
        dataSimApiNames.addAll(L43.DriverNames);
        dataSimApiNames.addAll(L44.DriverNames);
        dataSimApiNames.addAll(L45.DriverNames);
        dataSimApiNames.addAll(L46.DriverNames);
        dataSimApiNames.addAll(L47.DriverNames);
        dataSimApiNames.addAll(L48.DriverNames);
        dataSimApiNames.addAll(L49.DriverNames);
        dataSimApiNames.addAll(L50.DriverNames);

        dataSimApiNames.addAll(L51.DriverNames);
        dataSimApiNames.addAll(L52.DriverNames);
        dataSimApiNames.addAll(L53.DriverNames);
        dataSimApiNames.addAll(L54.DriverNames);
        dataSimApiNames.addAll(L55.DriverNames);


        for (int i = 0; i < dataSimApi.size(); i++) {

            double time = dataSimApi.get(i);

            int r = (int) (Math.random() * 10);
            int oe = (int) (Math.random() * 2 + 1);

            int e = (int) (Math.random() * 10);

            if (oe == 1) {
                time= time + r;
            } else {
                time = time - r;
            }

            if (e == 1) {

                time = 999999999;
            }

            dataSimApi.set(i, time);

        }


        Collections.sort(dataSimApi);
        Collections.sort(dataSimApi, Comparator.comparingInt(left -> dataSimApiNames.indexOf(left)));

        String my_users = "";


        for(int i = 1; i< 15; i++) {

            my_users = my_users + "Pos: " + i + " - " + dataSimApiNames.get(i) + " Time: " + (dataSimApi.get(i)/60) + "\n";

        }

        resultsTextView.setText(my_users);


    }


}