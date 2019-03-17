package com.application.jojobudiman.konigeldandroid.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.application.jojobudiman.konigeldandroid.R;


public class MenuChoice extends AppCompatActivity {

    private Button signUp, signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuchoice);

        signUp = (Button) findViewById(R.id.signup);
        signIn = (Button) findViewById(R.id.signin);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignUp.class);
                startActivity(i);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignIn.class);
                startActivity(i);
            }
        });

    }
}
