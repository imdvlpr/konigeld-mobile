package com.application.jojobudiman.konigeldandroid.transactions;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class Transactions extends Fragment {

    public Transactions() {


        // Required empty public constructor
    }
    DrawerLayout drawer;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ImageButton menu;
    LinearLayout paygains, includeview;
    TextView ramount, rtime;
    ListView receipts;
    protected Cursor cursor;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_transactions, container, false);

        receipts = (ListView) view.findViewById(R.id.receiptList);
        paygains = (LinearLayout) view.findViewById(R.id.transaction_receipt);
        ramount = (TextView) view.findViewById(R.id.amount);
        rtime = (TextView) view.findViewById(R.id.time);


        /*menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });*/

        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }
}

