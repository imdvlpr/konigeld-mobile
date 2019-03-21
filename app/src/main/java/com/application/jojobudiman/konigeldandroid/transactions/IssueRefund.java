package com.application.jojobudiman.konigeldandroid.transactions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.application.jojobudiman.konigeldandroid.R;

public class IssueRefund extends AppCompatActivity {

    ImageButton close;
    Button refund;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_refund);

        close = (ImageButton) findViewById(R.id.menu);
        refund = (Button) findViewById(R.id.refundbtn);


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ReceiptDetails.class);
                startActivity(i);
            }
        });

        refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ReceiptDetails.class);
                startActivity(i);
            }
        });


    }
}
