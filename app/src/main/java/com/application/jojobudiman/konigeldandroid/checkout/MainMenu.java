package com.application.jojobudiman.konigeldandroid.checkout;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;

public class MainMenu extends Fragment {

    public MainMenu() {


        // Required empty public constructor
    }

    ImageButton menu;
    Button charge;
    TextView calcoutput;
    Button one, two, three, four, five, six, seven, eight, nine, zero, clear, add;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.calculatorcount, container, false);

        calcoutput = (TextView) view.findViewById(R.id.output);
        one = (Button) view.findViewById(R.id.onebtn);
        two = (Button) view.findViewById(R.id.twobtn);
        three = (Button) view.findViewById(R.id.threebtn);
        four = (Button) view.findViewById(R.id.fourbtn);
        five = (Button) view.findViewById(R.id.fivebtn);
        six = (Button) view.findViewById(R.id.sixbtn);
        seven = (Button) view.findViewById(R.id.sevenbtn);
        eight = (Button) view.findViewById(R.id.eightbtn);
        nine = (Button) view.findViewById(R.id.ninebtn);
        zero = (Button) view.findViewById(R.id.zerobtn);
        clear = (Button) view.findViewById(R.id.clearbtn);
        add = (Button) view.findViewById(R.id.addbtn);


        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
