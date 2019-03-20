package com.application.jojobudiman.konigeldandroid.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.application.jojobudiman.konigeldandroid.R;

public class PleaseSignUp extends AppCompatActivity {

    ImageButton bacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_please_sign_up);

        bacc = (ImageButton) findViewById(R.id.backmenu);

        bacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuChoice.class);
                startActivity(i);
            }
        });



    }
}
