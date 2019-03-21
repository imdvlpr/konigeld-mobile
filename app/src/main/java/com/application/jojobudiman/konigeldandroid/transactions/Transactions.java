package com.application.jojobudiman.konigeldandroid.transactions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.application.jojobudiman.konigeldandroid.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Transactions extends Fragment {
    public Transactions() {


        // Required empty public constructor
    }

    private RecyclerView receipts;
    private ArrayList<Receipt> list = new ArrayList<>();
    ImageButton menubtn;
    LinearLayout paygains;
    protected Cursor cursor;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_transactions, container, false);

        final DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);

        menubtn = (ImageButton) view.findViewById(R.id.menu);
        receipts = (RecyclerView) view.findViewById(R.id.receiptList);
        receipts.setHasFixedSize(true);
        list.addAll(ReceiptData.getListData());
        showRecyclerList();



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

    private void showRecyclerList() {
        receipts.setLayoutManager(new LinearLayoutManager(getActivity())); // Vertical LinearLayout is the type of RecyclerView
        ReceiptAdapter receiptadapter = new ReceiptAdapter(getActivity()); // Create Adapter object that extends RecyclerViewAdapter
        receiptadapter.setReceiptList(list); // Call setter method dri ArrayList yg menampung data sbg parameter
        receipts.setAdapter(receiptadapter); // Set adapter ke RecyclerView

        // Call itemclicksupport class and static method addto,
        // sehingga attach event click ke item yang ada di RecyclerView
        /*ItemClickSupport.addTo(receipts).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            // Apply method from interface
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                // Call method to show toast message
                showRecyclerList(list.get(position));
            }
        });*/
    }

    /*public void onItemClick(int position) {
        // The onClick implementation of the RecyclerView item click
        Intent i = new Intent(getActivity(), ReceiptDetails.class);
        startActivity(i);
    }*/

    /*private void showSelectedReceipt(Receipt receipt){
        // Toast message untuk menunjukkan kamu memilih nama apa
        Toast.makeText(this, "Kamu memilih " + receipt.getTotal(), Toast.LENGTH_SHORT).show();
    }*/

}

