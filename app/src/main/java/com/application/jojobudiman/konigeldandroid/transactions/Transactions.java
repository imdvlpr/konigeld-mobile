package com.application.jojobudiman.konigeldandroid.transactions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;

import org.w3c.dom.Text;

public class Transactions extends Fragment {

    public Transactions() {


        // Required empty public constructor
    }

    String[] lists;
    LinearLayout paygains;
    TextView ramount, rtime;
    ListView receipts;
    protected Cursor cursor;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_transactions, container, false);

        final DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        receipts = (ListView) view.findViewById(R.id.receiptList);
        paygains = (LinearLayout) view.findViewById(R.id.transaction_receipt);
        ramount = (TextView) view.findViewById(R.id.amount);
        rtime = (TextView) view.findViewById(R.id.time);


        receipts.setAdapter(new ArrayAdapter(getActivity(), R.layout.transaction_receipts, R.id.amount));
        receipts.setSelected(true);


        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }
}

