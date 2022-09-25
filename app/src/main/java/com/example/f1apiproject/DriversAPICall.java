package com.example.f1apiproject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DriversAPICall {
    TextView resultsTextView;
    String myUrl = "";
    ArrayList<String> driverID   = new ArrayList<>();
    ArrayList<String> driverNum  = new ArrayList<>();
    ArrayList<String> driverCode = new ArrayList<>();
    ArrayList<String> driverUrl  = new ArrayList<>();
    ArrayList<String> driverGname = new ArrayList<>();
    ArrayList<String> driverFName = new ArrayList<>();
    ArrayList<String> driverDOB   = new ArrayList<>();
    ArrayList<String> driverNat   = new ArrayList<>();


    public DriversAPICall(String url) {
        myUrl = url;
        DriversAPICall.MyAsyncTasks myAsyncTasks = new DriversAPICall.MyAsyncTasks();
        myAsyncTasks.execute();
    }

    public class MyAsyncTasks extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
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
                JSONObject driverTableObj = mrDataObject.getJSONObject("DriverTable");
                JSONArray jsonArray1 = driverTableObj.getJSONArray("Drivers");
                String my_users = "";

                for (int i = 0; i < jsonArray1.length(); i++) {
                    JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
                    if(myUrl == "https://ergast.com/api/f1/2017/drivers.json" && i == 3) {
                        i++;
                    }
                    else  {
                        driverID.add(jsonObject1.getString("driverId"));
                        driverNum.add(jsonObject1.getString("permanentNumber"));
                        driverCode.add(jsonObject1.getString("code"));
                        driverUrl.add(jsonObject1.getString("url"));
                        driverGname.add(jsonObject1.getString("givenName"));
                        driverFName.add(jsonObject1.getString("familyName"));
                        driverDOB.add(jsonObject1.getString("dateOfBirth"));
                        driverNat.add(jsonObject1.getString("nationality"));
                    }
                }
                //Show the Textview after fetching data
                //resultsTextView.setVisibility(View.VISIBLE);
                System.out.println(driverFName.get(0));
                //Display data with the Textview
                //resultsTextView.setText(my_users);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<String> getDriverCode() {
        return driverCode;
    }

    public ArrayList<String> getDriverDOB() {
        return driverDOB;
    }

    public ArrayList<String> getDriverFName() {
        return driverFName;
    }

    public ArrayList<String> getDriverGname() {
        return driverGname;
    }

    public ArrayList<String> getDriverID() {
        return driverID;
    }

    public ArrayList<String> getDriverNat() {
        return driverNat;
    }

    public ArrayList<String> getDriverNum() {
        return driverNum;
    }

    public ArrayList<String> getDriverUrl() {
        return driverUrl;
    }
}
