package com.application.jojobudiman.konigeldandroid.checkout;

import androidx.appcompat.app.AppCompatActivity;
import com.application.jojobudiman.konigeldandroid.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PaymentSuccess extends AppCompatActivity {

    private TextView newsale, norec;
    private ImageView emailsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);

        newsale = (TextView) findViewById(R.id.newsale);
        emailsend = (ImageView) findViewById(R.id.emailme);
        norec = (TextView) findViewById(R.id.noReceipt);


        emailsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PaymentSuccessEmailReceipt.class);
                startActivity(i);
            }
        });


        newsale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainFragment.class);
                startActivity(i);
            }
        });

        norec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PaymentSuccessNoReceipt.class);
                startActivity(i);
            }
        });


    }
}
