package com.application.jojobudiman.konigeldandroid.checkout;

import androidx.appcompat.app.AppCompatActivity;
import com.application.jojobudiman.konigeldandroid.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PaymentSuccessEmailReceipt extends AppCompatActivity {

    private TextView newsale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success_email_receipt);

        newsale = (TextView) findViewById(R.id.newsale);

        newsale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainFragment.class);
                startActivity(i);
            }
        });
    }
}
