package com.application.jojobudiman.konigeldandroid.transactions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.application.jojobudiman.konigeldandroid.R;

public class IssueRefund extends AppCompatActivity {

    ImageButton close;
    Button refund;
    RadioGroup refundreasons;
    RadioButton refbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_refund);

        close = (ImageButton) findViewById(R.id.menu);
        refund = (Button) findViewById(R.id.refundbtn);
        refundreasons = (RadioGroup) findViewById(R.id.reasonrefund);
        refundreasons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                refbtn = (RadioButton) findViewById(checkedId);
                /*for (int i = 0; i < refundreasons.getChildCount(); i++) {
                    if (refundreasons.getChildAt(i).getId() == checkedId) {
                        position = i + 1; //+1 is used to have a start value of 1 like your example
                        break;
                    }
                }*/
            }
        });


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ReceiptDetails.class);
                startActivity(i);
                finish();
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
