package com.application.jojobudiman.konigeldandroid.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.application.jojobudiman.konigeldandroid.R;


public class SignIn extends AppCompatActivity {

    private Button login;
    private EditText email, pass;
    private TextView forgotpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signincredentials);

        login = (Button) findViewById(R.id.signin);
        email = (EditText) findViewById(R.id.emailText);
        pass = (EditText) findViewById(R.id.passwordText);
        forgotpass = (TextView) findViewById(R.id.forgetpass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  semail, spass;
                semail = email.getText().toString();
                spass = pass.getText().toString();

                if (semail.length() == 0 || spass.length() == 0) {
                    Toast.makeText(getApplication(), "All fields must be filled!", Toast.LENGTH_SHORT).show();
                }
                else {

                }

                Intent i = new Intent(getApplicationContext(), WelcomeText.class);
                startActivity(i);
            }
        });


    }
}
