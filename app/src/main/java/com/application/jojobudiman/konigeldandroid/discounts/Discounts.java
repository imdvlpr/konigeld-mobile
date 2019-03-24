package com.application.jojobudiman.konigeldandroid.discounts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.products.ProductData;
import com.application.jojobudiman.konigeldandroid.products.ProductListAdapter;

import java.util.ArrayList;

public class Discounts extends AppCompatActivity {

    ImageButton menubtn;
    private RecyclerView discounts;
    private ArrayList<Discount> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discounts);

        menubtn = (ImageButton) findViewById(R.id.menu);

        discounts = (RecyclerView) findViewById(R.id.discountList);
        discounts.setHasFixedSize(true);
        list.addAll(DiscountData.getListData());
        showRecylerList();


        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showRecylerList() {
        discounts.setLayoutManager(new LinearLayoutManager(this));
        DiscountAdapter discountadapter = new DiscountAdapter(this);
        discountadapter.setDiscountList(list);
        discounts.setAdapter(discountadapter);
    }

}
