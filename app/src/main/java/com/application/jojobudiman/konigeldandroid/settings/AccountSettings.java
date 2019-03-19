package com.application.jojobudiman.konigeldandroid.settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;

public class AccountSettings extends Fragment {

    public AccountSettings() {


        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_account_settings, container, false);


        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
