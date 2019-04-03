package com.application.jojobudiman.konigeldandroid.checkout;

import androidx.appcompat.app.AppCompatActivity;
import com.application.jojobudiman.konigeldandroid.R;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PaymentSuccess extends AppCompatActivity {

    private TextView newsale, norec, ch;
    private ImageView emailsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);

        newsale = (TextView) findViewById(R.id.newsale);
        emailsend = (ImageView) findViewById(R.id.emailme);
        norec = (TextView) findViewById(R.id.noReceipt);
        ch = (TextView) findViewById(R.id.change);

        final SharedPreferences sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        int total = sharedPreferences.getInt("bayar", 0);
        String tot = sharedPreferences.getString("total", "defaultValue");
        String words[] = tot.split(" ");

        String jmlh = words[1];
        int byr = Integer.parseInt(jmlh);
        int chang = total - byr;
        //Toast.makeText(getApplicationContext(), ""+total, Toast.LENGTH_LONG).show();
        if(chang == 0) {
            ch.setText("No change out of Rp "+jmlh);
        }
        else {
            ch.setText("Rp "+chang+" change out of Rp "+total);
        }


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
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("bayar");
                editor.remove("total");
                editor.commit();

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
