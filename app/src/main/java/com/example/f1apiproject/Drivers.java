package com.example.f1apiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

public class Drivers extends AppCompatActivity {
    String myUrl = "https://ergast.com/api/f1/2021/drivers.json";
    TextView resultsTextView, nametxt, idtxt, dobtxt, numtxt, nattxt, urltxt;
    ProgressDialog progressDialog;
    ImageView driverimgV;
    Button displayData2022, displayData2021, displayData2020, displayData2019, displayData2018, displayData2017, displayData2016, displayData2015, button2, nextbtn, prevbtn;
    DriversAPICall DR2022, DR2021, DR2020, DR2019, DR2018, DR2017, DR2016, DR2015;
    int ArrayLEN = 0, currArrayIND = 0, currYEAR = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers);

        resultsTextView = (TextView) findViewById(R.id.results);
        displayData2022 = (Button) findViewById(R.id.displayData2022);
        displayData2021 = (Button) findViewById(R.id.displayData2021);
        displayData2020 = (Button) findViewById(R.id.displayData2020);
        displayData2019 = (Button) findViewById(R.id.displayData2019);
        displayData2018 = (Button) findViewById(R.id.displayData2018);
        displayData2017 = (Button) findViewById(R.id.displayData2017);
        displayData2016 = (Button) findViewById(R.id.displayData2016);
        displayData2015 = (Button) findViewById(R.id.displayData2015);
        nextbtn = (Button) findViewById(R.id.nextbtn);
        prevbtn = (Button) findViewById(R.id.prevbtn);
        nametxt = (TextView) findViewById(R.id.nametxt);
        idtxt  = (TextView) findViewById(R.id.idtxt);
        dobtxt = (TextView) findViewById(R.id.dobtxt);
        numtxt = (TextView) findViewById(R.id.numtxt);
        nattxt = (TextView) findViewById(R.id.nattxt);
        urltxt = (TextView) findViewById(R.id.urltxt);
        driverimgV = (ImageView) findViewById(R.id.driverimgV);
        DR2022 = new DriversAPICall("https://ergast.com/api/f1/2022/drivers.json");
        DR2021 = new DriversAPICall("https://ergast.com/api/f1/2021/drivers.json");
        DR2020 = new DriversAPICall("https://ergast.com/api/f1/2020/drivers.json");
        DR2019 = new DriversAPICall("https://ergast.com/api/f1/2019/drivers.json");
        DR2018 = new DriversAPICall("https://ergast.com/api/f1/2018/drivers.json");
        DR2017 = new DriversAPICall("https://ergast.com/api/f1/2017/drivers.json");
        DR2016 = new DriversAPICall("https://ergast.com/api/f1/2016/drivers.json");
        DR2015 = new DriversAPICall("https://ergast.com/api/f1/2015/drivers.json");
    }
    public void back(View view) {
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }
    public void clearbuttons() {
        displayData2022.setVisibility(View.GONE);
        displayData2021.setVisibility(View.GONE);
        displayData2020.setVisibility(View.GONE);
        displayData2019.setVisibility(View.GONE);
        displayData2018.setVisibility(View.GONE);
        displayData2017.setVisibility(View.GONE);
        displayData2016.setVisibility(View.GONE);
        displayData2015.setVisibility(View.GONE);
        idtxt.setVisibility(View.VISIBLE);
        dobtxt.setVisibility(View.VISIBLE);
        numtxt.setVisibility(View.VISIBLE);
        nattxt.setVisibility(View.VISIBLE);
        urltxt.setVisibility(View.VISIBLE);
        driverimgV.setVisibility(View.VISIBLE);
        nextbtn.setVisibility(View.VISIBLE);
        prevbtn.setVisibility(View.VISIBLE);
    }

    public void Display(DriversAPICall year, int index) {
        Resources resources = getResources();
        int resourceId = 0;
        idtxt.setText("iD: " + year.getDriverGname().get(index) + year.getDriverFName());
        dobtxt.setText("DOB: "+year.getDriverDOB().get(index));
        numtxt.setText("PNUM: "+ year.getDriverNum().get(index));
        nattxt.setText("NAT: "+year.getDriverNat().get(index));
        urltxt.setText("URL: "+year.getDriverUrl().get(index));
        resourceId = resources.getIdentifier(year.getDriverFName().get(index).toLowerCase(Locale.ROOT), "drawable", getPackageName());
        driverimgV.setImageResource(resourceId);
    }

    public void run(View view) {
        clearbuttons();
        Resources resources = getResources();
        int resourceId = 0;
        switch (view.getId()) {
            case R.id.displayData2022:
                ArrayLEN = DR2022.getDriverID().size();
                resourceId = resources.getIdentifier(DR2022.getDriverFName().get(0).toLowerCase(Locale.ROOT), "drawable", getPackageName());
                currYEAR = 2022;
                Display(DR2022, 0);
                break;
            case R.id.displayData2021:
                ArrayLEN = DR2021.getDriverID().size();
                Display(DR2021, 0);
                currYEAR = 2021;
                resourceId = resources.getIdentifier(DR2021.getDriverFName().get(0).toLowerCase(Locale.ROOT), "drawable", getPackageName());
                break;
            case R.id.displayData2020:
                ArrayLEN = DR2020.getDriverID().size();
                Display(DR2020, 0);
                currYEAR = 2020;
                resourceId = resources.getIdentifier(DR2020.getDriverFName().get(0).toLowerCase(Locale.ROOT), "drawable", getPackageName());
                break;
            case R.id.displayData2019:
                ArrayLEN = DR2019.getDriverID().size();
                Display(DR2019, 0);
                currYEAR = 2019;
                resourceId = resources.getIdentifier(DR2019.getDriverFName().get(0).toLowerCase(Locale.ROOT), "drawable", getPackageName());
                break;
            case R.id.displayData2018:
                ArrayLEN = DR2018.getDriverID().size();
                Display(DR2018, 0);
                currYEAR = 2018;
                resourceId = resources.getIdentifier(DR2018.getDriverFName().get(0).toLowerCase(Locale.ROOT), "drawable", getPackageName());
                break;
            case R.id.displayData2017:
                ArrayLEN = DR2017.getDriverID().size();
                Display(DR2017, 0);
                currYEAR = 2017;
                resourceId = resources.getIdentifier(DR2017.getDriverFName().get(0).toLowerCase(Locale.ROOT), "drawable", getPackageName());
                break;
            case R.id.displayData2016:
                ArrayLEN = DR2016.getDriverID().size();
                Display(DR2016, 0);
                currYEAR = 2016;
                resourceId = resources.getIdentifier(DR2016.getDriverFName().get(0).toLowerCase(Locale.ROOT), "drawable", getPackageName());
                break;
            case R.id.displayData2015:
                ArrayLEN = DR2015.getDriverID().size();
                Display(DR2015, 0);
                currYEAR = 2015;
                resourceId = resources.getIdentifier(DR2015.getDriverFName().get(0).toLowerCase(Locale.ROOT), "drawable", getPackageName());
                break;
        }
        driverimgV.setImageResource(resourceId);
    }

    public void clickNext(View view) {
        if(currArrayIND != ArrayLEN) {
            currArrayIND++;
            if(currYEAR == 2022) {
                Display(DR2022, currArrayIND);
            }
            else if(currYEAR == 2021) {
                Display(DR2021, currArrayIND);
            }
            else if(currYEAR == 2020) {
                Display(DR2020, currArrayIND);
            }
            else if(currYEAR == 2019) {
                Display(DR2019, currArrayIND);
            }
            else if(currYEAR == 2018) {
                Display(DR2018, currArrayIND);
            }
            else if(currYEAR == 2017) {
                Display(DR2017, currArrayIND);
            }
            else if(currYEAR == 2016) {
                Display(DR2016, currArrayIND);
            }
            else if(currYEAR == 2015) {
                Display(DR2015, currArrayIND);
            }
        }
    }

    public void clickPrev(View view) {
        if(currArrayIND != 0) {
            currArrayIND--;
            if(currYEAR == 2022) {
                Display(DR2022, currArrayIND);
            }
            else if(currYEAR == 2021) {
                Display(DR2021, currArrayIND);
            }
            else if(currYEAR == 2020) {
                Display(DR2020, currArrayIND);
            }
            else if(currYEAR == 2019) {
                Display(DR2019, currArrayIND);
            }
            else if(currYEAR == 2018) {
                Display(DR2018, currArrayIND);
            }
            else if(currYEAR == 2017) {
                Display(DR2017, currArrayIND);
            }
            else if(currYEAR == 2016) {
                Display(DR2016, currArrayIND);
            }
            else if(currYEAR == 2015) {
                Display(DR2015, currArrayIND);
            }
        }
    }

    public class MyAsyncTasks extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(Drivers.this);
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
            progressDialog.dismiss();
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONObject mrDataObject = jsonObject.getJSONObject("MRData");
                JSONObject driverTableObj = mrDataObject.getJSONObject("RaceTable");
                JSONArray jsonArray1 = driverTableObj.getJSONArray("Drivers");
                String my_users = "";

                for (int i = 0; i < jsonArray1.length(); i++) {
                    JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
                    String id = jsonObject1.getString("permanentNumber");
                    String name = jsonObject1.getString("driverId");
                    my_users = my_users + "User ID: " + id + "\n" + "Name: " + name + "\n\n";
                }

                resultsTextView.setVisibility(View.VISIBLE);
                resultsTextView.setText(my_users);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }




}