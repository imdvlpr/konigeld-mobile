package com.application.jojobudiman.konigeldandroid.settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.content.Intent;
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
import com.application.jojobudiman.konigeldandroid.starter.SignIn;

public class AccountSettings extends Fragment {

    public AccountSettings() {


        // Required empty public constructor
    }

    ImageButton menubtn;
    Button logout;
    Dialog popup;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_account_settings, container, false);
        final DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);

        menubtn = (ImageButton) view.findViewById(R.id.menu);
        logout = (Button) view.findViewById(R.id.logout);
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

        popup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popup.show();
    }

}
