package com.application.jojobudiman.konigeldandroid.settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.starter.MenuChoice;
import com.application.jojobudiman.konigeldandroid.starter.SignIn;
import com.application.jojobudiman.konigeldandroid.starter.WelcomeText;

public class AccountSettings extends Fragment {

    public AccountSettings() {


        // Required empty public constructor
    }

    Activity mActivity;
    ImageButton menubtn;
    Button logout;
    Dialog popup;
    TextView name, bs, init;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_account_settings, container, false);
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        final DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);

        menubtn = (ImageButton) view.findViewById(R.id.menu);
        logout = (Button) view.findViewById(R.id.logout);
        name = (TextView) view.findViewById(R.id.fullname);
        bs = (TextView) view.findViewById(R.id.outletname);
        init = (TextView) view.findViewById(R.id.fullabbr);
        String fname = sharedPreferences.getString("fname", "defaultValue");
        String lname = sharedPreferences.getString("lname", "defaultValue");
        String alamat = sharedPreferences.getString("alamat", "defaultValue");
        String bisnis = sharedPreferences.getString("bisnis", "defaultValue");

        String fn = String.valueOf(fname.charAt(0));
        String ln = String.valueOf(lname.charAt(0));
        name.setText(fname+" "+lname);
        init.setText(fn+ln);
        bs.setText(bisnis+"\n"+alamat);

        popup = new Dialog(getContext());


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUp();
            }
        });

        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private void showPopUp() {

        ImageButton closelog;
        LinearLayout yeslog, nolog;
        popup.setContentView(R.layout.logoutpopup);

        closelog = (ImageButton) popup.findViewById(R.id.closebtn);
        yeslog = (LinearLayout) popup.findViewById(R.id.logoutyes);
        nolog = (LinearLayout) popup.findViewById(R.id.logoutno);

        closelog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });

        nolog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });

        yeslog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), MenuChoice.class);
                startActivity(i);
            }
        });

        popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popup.show();
    }

}
