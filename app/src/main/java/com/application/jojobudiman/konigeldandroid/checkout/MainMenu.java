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
    String a;


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


        final int[] ans = {0};
        
        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    calcoutput.setText(a + " " + "1");
                    ans[0] = 0;
                }

                else {

                    a = a + "1";
                    calcoutput.setText(a);
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    calcoutput.setText(a + " " + "2");
                    ans[0] = 0;
                }

                else {
                    a = calcoutput.getText().toString();
                    a = a + "2";
                    calcoutput.setText(a);
                }
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    calcoutput.setText(a + " " + "3");
                    ans[0] = 0;
                }

                else {
                    a = calcoutput.getText().toString();
                    a = a + "3";
                    calcoutput.setText(a);
                }
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    calcoutput.setText(a + " " + "4");
                    ans[0] = 0;
                }

                else {
                    a = calcoutput.getText().toString();
                    a = a + "4";
                    calcoutput.setText(a);
                }
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    calcoutput.setText(a + " " + "5");
                    ans[0] = 0;
                }

                else {
                    a = calcoutput.getText().toString();
                    a = a + "5";
                    calcoutput.setText(a);
                }
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    calcoutput.setText(a + " " + "6");
                    ans[0] = 0;
                }

                else {
                    a = calcoutput.getText().toString();
                    a = a + "6";
                    calcoutput.setText(a);
                }
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    calcoutput.setText(a + " " + "7");
                    ans[0] = 0;
                }

                else {
                    a = calcoutput.getText().toString();
                    a = a + "7";
                    calcoutput.setText(a);
                }
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    calcoutput.setText(a + " " + "8");
                    ans[0] = 0;
                }

                else {
                    a = calcoutput.getText().toString();
                    a = a + "8";
                    calcoutput.setText(a);
                }
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    calcoutput.setText(a + " " + "9");
                    ans[0] = 0;
                }

                else {
                    a = calcoutput.getText().toString();
                    a = a + "9";
                    calcoutput.setText(a);
                }
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    calcoutput.setText(a + " " + "0");
                    ans[0] = 0;
                }

                else {
                    a = calcoutput.getText().toString();
                    a = a + "0";
                    calcoutput.setText(a);
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
