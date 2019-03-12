package com.application.jojobudiman.konigeldandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainFragment extends AppCompatActivity {

    private MainMenu CustomFragment;
    private MainMenu2 LibraryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
    }
}
