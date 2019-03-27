package com.application.jojobudiman.konigeldandroid.transactions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.starter.SignIn;

import java.util.ArrayList;

public class ReceiptDetails extends AppCompatActivity {

    ImageButton bacc;
    Button newrec, refund;
    ViewPager viewPager;
    private RecyclerView items;
    private ArrayList<Item> list = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_details);



        newrec = (Button) findViewById(R.id.newreceipt);
        refund = (Button) findViewById(R.id.issuerefund);
        bacc = (ImageButton) findViewById(R.id.menu);


        bacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        items = (RecyclerView) findViewById(R.id.itemsList);
        items.setHasFixedSize(true);
        list.addAll(ItemData.getListData());
        showRecyclerList();

        newrec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NewReceipt.class);
                startActivity(i);
            }
        });

        refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IssueRefund.class);
                startActivity(i);
            }
        });




    }

    private void showRecyclerList() {
        items.setLayoutManager(new LinearLayoutManager(this)); // Vertical LinearLayout is the type of RecyclerView
        ItemAdapter itemadapter = new ItemAdapter(this); // Create Adapter object that extends RecyclerViewAdapter
        itemadapter.setItemList(list); // Call setter method dri ArrayList yg menampung data sbg parameter
        items.setAdapter(itemadapter); // Set adapter ke RecyclerView

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

    @Override
    public void onBackPressed()
    {
        finish();
    }
}
