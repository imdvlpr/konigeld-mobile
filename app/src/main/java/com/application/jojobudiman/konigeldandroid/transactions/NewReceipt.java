package com.application.jojobudiman.konigeldandroid.transactions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.application.jojobudiman.konigeldandroid.R;

public class NewReceipt extends AppCompatActivity {

    ImageButton close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_receipt);

        close = (ImageButton) findViewById(R.id.menu);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ReceiptDetails.class);
                startActivity(i);
            }
        });
    }
}
