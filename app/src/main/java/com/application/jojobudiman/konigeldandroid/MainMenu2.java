package com.application.jojobudiman.konigeldandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainMenu2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating

        return inflater.inflate(R.layout.librarymenu, container, false);
    }
}
