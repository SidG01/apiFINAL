package com.example.f1apiproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {

        super.onStart();
        ImageButton ib1 = findViewById(R.id.driversButton);
        ImageButton ib2 = findViewById(R.id.constructorsButton);
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        Animation sfr = AnimationUtils.loadAnimation(this, R.anim.slide_from_right_button);
        Animation sfl = AnimationUtils.loadAnimation(this, R.anim.slide_from_left_button);
        tv1.startAnimation(sfr);
        tv2.startAnimation(sfl);
        ib1.startAnimation(sfr);
        ib2.startAnimation(sfl);

    }

    public void loadDriverActivity(View view) {

        startActivity(new Intent(getApplicationContext(), Drivers.class));
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

    }

    public void loadSimulationActivity(View view) {

        startActivity(new Intent(getApplicationContext(), Simulation.class));
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);

    }

}