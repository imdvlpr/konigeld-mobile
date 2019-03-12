package com.application.jojobudiman.konigeldandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SignUp extends AppCompatActivity {

    private Button createAcc;
    private EditText first, last, email, pass, cpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupcredentials);

        createAcc = (Button) findViewById(R.id.signup);
        first = (EditText) findViewById(R.id.fname);
        last = (EditText) findViewById(R.id.lname);
        email = (EditText) findViewById(R.id.emailText);
        pass = (EditText) findViewById(R.id.passwordText);
        cpass = (EditText) findViewById(R.id.confirmpasswordText);

        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
