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
import com.application.jojobudiman.konigeldandroid.starter.SignIn;

public class ReceiptDetails extends AppCompatActivity {

    ImageButton bacc;
    Button newrec, refund;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_details);

        newrec = (Button) findViewById(R.id.newreceipt);
        refund = (Button) findViewById(R.id.issuerefund);
        bacc = (ImageButton) findViewById(R.id.menu);


        bacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Transactions.class);
                startActivity(i);
            }
        });

        newrec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NewReceipt.class);
                startActivity(i);
            }
        });

        refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IssueRefund.class);
                startActivity(i);
            }
        });


    }
}
