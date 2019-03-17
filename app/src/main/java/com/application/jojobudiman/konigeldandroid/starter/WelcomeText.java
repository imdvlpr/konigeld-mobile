package com.application.jojobudiman.konigeldandroid.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.checkout.MainFragment;

public class WelcomeText extends AppCompatActivity {

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcometext);

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
