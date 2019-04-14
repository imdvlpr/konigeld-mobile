package com.application.jojobudiman.konigeldandroid.checkout;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    SharedPreferences sess;
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
        sess = this.getActivity().getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor as = sess.edit();
        as.putString("total", "Rp ");
        as.apply();

        final int[] ans = {1};

        
        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a =  calcoutput.getText().toString();

                if (ans[0] == 1) { //
                    calcoutput.setText("Rp" + " " + "1");
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 1");
                    ans[0] = 0; //
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "1";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "2");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 2");
                    as.apply();
                }


                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "2";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "3");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 3");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "3";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "4");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 4");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "4";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "5");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 5");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "5";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "6");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 6");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "6";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "7");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 7");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "7";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "8");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 8");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "8";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "9");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 9");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "9";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "0");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 0");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "0";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcoutput.setText("Rp" + " " + "0.00");
                ans[0] = 1;
                SharedPreferences.Editor as = sess.edit();
                as.putString("total", "Rp 0");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
