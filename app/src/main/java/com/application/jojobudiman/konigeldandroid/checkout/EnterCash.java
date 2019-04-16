package com.application.jojobudiman.konigeldandroid.checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.application.jojobudiman.konigeldandroid.R;

public class EnterCash extends AppCompatActivity {

    private Button suggest1, suggest2, suggest3, finalcharge;
    private ImageView close;
    private EditText price;
    TextView total;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_cash);

        close = (ImageView) findViewById(R.id.menu);
        suggest1 = (Button) findViewById(R.id.onebtn);
        suggest2 = (Button) findViewById(R.id.twobtn);
        suggest3 = (Button) findViewById(R.id.threebtn);
        price = (EditText) findViewById(R.id.priceText);
        total = (TextView) findViewById(R.id.textView2);
        finalcharge = (Button) findViewById(R.id.chargebtn);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String tota = sharedPreferences.getString("finn", "defaultValue");

        total.setText(tota + " Cash");

        String words[] = tota.split(" ");
        String jmlh = words[1];
        final int hitung = Integer.parseInt(jmlh);
        int count = 0;
        int pecah = 0;
        int ketiga = 0;
        if(hitung <= 5000) {
            pecah = 5000;
            ketiga = 10000;
        }
        else if(hitung <= 10000) {
            pecah = 10000;
            ketiga = 20000;
        }
        else {
            while(count <= 0) {
                pecah = pecah + 50000;
                count = pecah - hitung;
                //Toast.makeText(getApplicationContext(), pecah,Toast.LENGTH_LONG).show();
                ketiga = pecah + 50000;
            }
        }

        suggest1.setText(""+hitung);
        suggest2.setText(""+pecah);
        suggest3.setText(""+ketiga);

        editor.putString("total", tota);
        editor.apply();

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ChargePayment.class);
                startActivity(i);
            }
        });

        suggest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price.setText(""+hitung);
                SharedPreferences sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("bayar", hitung);
                editor.apply();
            }
        });

        final int finalPecah = pecah;
        suggest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price.setText(""+finalPecah);
                SharedPreferences sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("bayar", finalPecah);
                editor.apply();
            }
        });

        final int finalKetiga = ketiga;
        suggest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price.setText(""+finalKetiga);
                SharedPreferences sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("bayar", finalKetiga);
                editor.apply();
            }
        });

        finalcharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "http://10.0.2.2/semester8/konigeld/assets/mobile/insert.php?";
                Intent i = new Intent(getApplicationContext(), PaymentSuccess.class);
                startActivity(i);
            }
        });

    }
}
