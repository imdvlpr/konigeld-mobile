package com.application.jojobudiman.konigeldandroid.checkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.application.jojobudiman.konigeldandroid.R;

public class EnterCash extends AppCompatActivity {

    private Button suggest1, suggest2, suggest3, finalcharge;
    private ImageView close;
    private EditText price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_cash);

        close = (ImageView) findViewById(R.id.menu);
        suggest1 = (Button) findViewById(R.id.onebtn);
        suggest2 = (Button) findViewById(R.id.twobtn);
        suggest3 = (Button) findViewById(R.id.threebtn);
        price = (EditText) findViewById(R.id.priceText);
        finalcharge = (Button) findViewById(R.id.chargebtn);

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
                price.setText("350000");
            }
        });

        suggest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price.setText("400000");
            }
        });

        suggest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price.setText("450000");
            }
        });

        finalcharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PaymentSuccess.class);
                startActivity(i);
            }
        });

    }
}
