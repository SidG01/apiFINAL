package com.example.f1apiproject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class SImAPICall {
    String myUrl = "";
    ArrayList<String> DriverNames = new ArrayList<>();
    ArrayList<String> DriverTimes = new ArrayList<>();
    ArrayList<String> newDriverTime = new ArrayList<>();
    ArrayList<Double> DriverTimeDOUBLE  = new ArrayList<>();
    public SImAPICall(String url) {
        myUrl  = url;
        MyAsyncTasks myAsyncTasks = new MyAsyncTasks();
        myAsyncTasks.execute();
    }
    public class MyAsyncTasks extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
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
                    return result;

                } catch (Exception e) {
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
                for(int i = 0; i<DriverTimes.size(); i++)  {

                    double seconds = 0;

                    newDriverTime.add(DriverTimes.get(i).substring(0,1) + DriverTimes.get(i).substring(2,4) + DriverTimes.get(i).substring(5));

                    seconds = seconds + Integer.parseInt(DriverTimes.get(i).substring(0,1)) * 60;
                    seconds = seconds + Integer.parseInt( DriverTimes.get(i).substring(2,4));

                    DriverTimeDOUBLE.add(seconds);
                }
                System.out.println(DriverTimeDOUBLE);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public ArrayList<Double> getDriverTimeDOUBLE() {
        return DriverTimeDOUBLE;
    }

    public ArrayList<String> getDriverNames() {
        return DriverNames;
    }

}
