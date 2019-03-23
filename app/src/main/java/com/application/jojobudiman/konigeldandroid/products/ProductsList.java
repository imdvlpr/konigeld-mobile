package com.application.jojobudiman.konigeldandroid.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.application.jojobudiman.konigeldandroid.R;

import java.util.ArrayList;

public class ProductsList extends AppCompatActivity {

    private RecyclerView products;
    private ArrayList<Product> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        products = (RecyclerView) findViewById(R.id.productList);
        products.setHasFixedSize(true);
        list.addAll(ProductData.getListData());
        showRecylerList();

    }

    private void showRecylerList() {
        products.setLayoutManager(new LinearLayoutManager(this));
        ProductListAdapter productadapter = new ProductListAdapter(this);
        productadapter.setProductsList(list);
        products.setAdapter(productadapter);
    }
}
