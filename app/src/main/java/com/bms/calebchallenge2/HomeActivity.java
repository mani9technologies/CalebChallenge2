package com.bms.calebchallenge2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    CardView personalInfo,Results,settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        personalInfo = findViewById(R.id.personalInfo);
        Results = findViewById(R.id.results);
        settings = findViewById(R.id.settigns);

        //Redirects to the personal information activity
        personalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent personalInfoIntent = new Intent(HomeActivity.this,personalinfo.class);
                startActivity(personalInfoIntent);
            }
        });



    }
}