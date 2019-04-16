package com.application.jojobudiman.konigeldandroid.checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        String total2 = sharedPreferences.getString("finn", "Rp 0");
        //Toast.makeText(getApplicationContext(), total2, Toast.LENGTH_LONG).show();
        String words[] = total.split(" ");
        String fin = words[1];
        String words2[] = total2.split(" ");
        String fin2 = words2[1];
        tot = (TextView) findViewById(R.id.totalcharge);
        /*if(total2.equals("Rp 0")) {
            editor.putString("finn", total);
            editor.apply();
            tot.setText(total);
            Toast.makeText(getApplicationContext(), total2, Toast.LENGTH_LONG).show();
        }
        else {
            int fnl = Integer.parseInt(fin) + Integer.parseInt(fin2);
            editor.putString("finn", "Rp "+fnl);
            editor.apply();
            tot.setText("Rp "+fnl);
        }*/
        //editor.putString("finn", total);
        //editor.apply();
        tot.setText(total2);
        //Toast.makeText(getApplicationContext(), total2, Toast.LENGTH_LONG).show();



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
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("bayar");
                editor.remove("total");
                editor.remove("finn");
                editor.commit();
                Intent i = new Intent(getApplicationContext(), MainFragment.class);
                startActivity(i);
            }
        });

    }
}
