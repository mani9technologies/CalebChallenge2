package com.bms.calebchallenge2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {
    Button confirmButton;
    EditText username, password;
    String U = "ADMIN";
    String P = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.UN);
        password = findViewById(R.id.PS);
        confirmButton = findViewById(R.id.confirm);


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String uname = username.getText().toString();
                String pword = password.getText().toString();

                if (uname.equals(U)  && pword.equals(P)){
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Information Provided is Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}