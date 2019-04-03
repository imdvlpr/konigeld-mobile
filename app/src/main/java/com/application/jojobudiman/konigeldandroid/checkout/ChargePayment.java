package com.application.jojobudiman.konigeldandroid.checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;

public class ChargePayment extends AppCompatActivity {

    private TextView select;
    private ImageView x;
    TextView tot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge_payment);

        select = (TextView) findViewById(R.id.cashmethod);
        x = (ImageView) findViewById(R.id.menu);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String total = sharedPreferences.getString("total", "defaultValue");
        tot = (TextView) findViewById(R.id.totalcharge);
        tot.setText(total);


        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EnterCash.class);
                startActivity(i);
            }
        });

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainFragment.class);
                startActivity(i);
            }
        });

    }
}
