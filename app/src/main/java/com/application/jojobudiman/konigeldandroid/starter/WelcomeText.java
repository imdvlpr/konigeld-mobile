package com.application.jojobudiman.konigeldandroid.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.checkout.MainFragment;

public class WelcomeText extends AppCompatActivity {

    private Button next;
    TextView nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcometext);

        SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String fname = sharedPreferences.getString("fname", "defaultValue");
        String lname = sharedPreferences.getString("lname", "defaultValue");

        nm = (TextView) findViewById(R.id.welcomename);
        nm.setText(fname+" "+lname);

        next = (Button) findViewById(R.id.nextbtn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainFragment.class);
                startActivity(i);
            }
        });


    }
}
