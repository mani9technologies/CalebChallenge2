package com.bms.calebchallenge2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    EditText SignUpEmail,SignUppassword,SignUpnickname;
    Button confirm;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SignUpEmail = findViewById(R.id.WantedUsername);
        SignUppassword = findViewById(R.id.WantedPassword);
        SignUpnickname = findViewById(R.id.WantedNickname);
        confirm = findViewById(R.id.confirm_button);

        String emailconfirm = SignUpEmail.getText().toString();
        String passconfirm = SignUppassword.getText().toString();
        String nickconfirm = SignUpnickname.getText().toString();

        mAuth = FirebaseAuth.getInstance();




        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passconfirm.length()<6){
                    SignUppassword.setError("Password is must be more than 4 characters");
                }
                if(emailconfirm.isEmpty()){
                    SignUpEmail.setError("Username cannot be empty");
                }
                if(nickconfirm.isEmpty()){
                    SignUpnickname.setError("Nickname cannot be empty");
                }
                mAuth.createUserWithEmailAndPassword(emailconfirm, passconfirm)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    User user = new User(emailconfirm,nickconfirm);
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "Authentication failed",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });





    }
}