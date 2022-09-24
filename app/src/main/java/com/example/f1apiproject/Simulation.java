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
    String myUrl = "https://ergast.com/api/f1/2021/1/laps/1.json";
    TextView resultsTextView;
    ProgressDialog progressDialog;
    Button displayData;
    ArrayList<String> DriverNames = new ArrayList<>();
    ArrayList<String> DriverTimes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);
        resultsTextView = (TextView) findViewById(R.id.results);
        displayData = (Button) findViewById(R.id.displayData);
    }

    public void back(View view) {
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }


    public void run(View view) {
        MyAsyncTasks myAsyncTasks = new MyAsyncTasks();
        myAsyncTasks.execute();
    }


    public class MyAsyncTasks extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(Simulation.this);
            progressDialog.setMessage("processing results");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        // display a progress dialog to show the user what is happening


        @Override
        protected String doInBackground(String... params) {

            // Fetch data from the API in the background.

            String result = "";
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(myUrl);
                    //open a URL coonnection

                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream in = urlConnection.getInputStream();

                    InputStreamReader isw = new InputStreamReader(in);

                    int data = isw.read();

                    while (data != -1) {
                        result += (char) data;
                        data = isw.read();

                    }

                    // return the data to onPostExecute method
                    System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT" + result);
                    return result;

                } catch (Exception e) {
                    System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM" + e);
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {

            // dismiss the progress dialog after receiving data from API
            progressDialog.dismiss();
            try {

                JSONObject jsonObject = new JSONObject(s);
                JSONObject mrDataObject = jsonObject.getJSONObject("MRData");
                JSONObject driverTableObj = mrDataObject.getJSONObject("RaceTable");
                JSONArray jsonArray1 = driverTableObj.getJSONArray("Races");
                JSONObject jsonObject2 = jsonArray1.getJSONObject(0);
                JSONArray jsonArray3 = jsonObject2.getJSONArray("Laps");
                JSONObject jsonObject4 = jsonArray3.getJSONObject(0);
                JSONArray jsonArray4 = jsonObject4.getJSONArray("Timings");
                JSONObject jsonObjectFINAL = jsonArray4.getJSONObject(1);

                String my_users = "";
                for(int i = 0; i<jsonArray4.length(); i++) {
                    jsonObjectFINAL = jsonArray4.getJSONObject(i);
                    DriverNames.add(jsonObjectFINAL.getString("driverId"));
                    DriverTimes.add(jsonObjectFINAL.getString("time"));
                }
                for(int i = 0; i<DriverTimes.size(); i++) {
                    my_users = my_users + DriverNames.get(i) + " Time: " + DriverTimes.get(i) + "\n";
                }
//                }
                //Show the Textview after fetching data
                resultsTextView.setVisibility(View.VISIBLE);

                //Display data with the Textview
                resultsTextView.setText(my_users);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}