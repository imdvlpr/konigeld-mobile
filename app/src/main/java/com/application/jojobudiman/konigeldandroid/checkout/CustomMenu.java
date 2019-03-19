package com.application.jojobudiman.konigeldandroid.checkout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.sidebar.PagerAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class CustomMenu extends Fragment {

    public CustomMenu() {


        // Required empty public constructor
    }

    TabLayout selectButton;
    ViewPager viewPager;
    ImageButton menu;
    Button charge;
    DrawerLayout drawer;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_custom_menu, container, false);
        View iview = inflater.inflate(R.layout.activity_sidebar_menu, container, false);
        final DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);

        charge = (Button) view.findViewById(R.id.chargebtn);
        menu = (ImageButton) view.findViewById(R.id.hamburger);
        selectButton = (TabLayout) view.findViewById(R.id.checkoutTabs);
        viewPager = (ViewPager) view.findViewById(R.id.container);

        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));;
        // Give the TabLayout the ViewPager
        selectButton.setupWithViewPager(viewPager);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getBaseContext(), ChargePayment.class);
                startActivity(i);
            }
        });

        return view;

    }
}
