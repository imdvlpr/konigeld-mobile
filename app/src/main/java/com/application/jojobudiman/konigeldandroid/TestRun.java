package com.application.jojobudiman.konigeldandroid;

import android.content.Intent;
import android.os.Bundle;

import com.application.jojobudiman.konigeldandroid.transactions.Transactions;

import androidx.appcompat.app.AppCompatActivity;

public class TestRun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = new Intent(this, Transactions.class);
        startActivity(i);
    }

}
