package com.application.jojobudiman.konigeldandroid.categories;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.application.jojobudiman.konigeldandroid.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Categories extends AppCompatActivity {

    ImageButton menubtn;
    private RecyclerView categories;
    private ArrayList<Category> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        menubtn = (ImageButton) findViewById(R.id.menu);

        categories = (RecyclerView) findViewById(R.id.categoryList);
        categories.setHasFixedSize(true);
        list.addAll(CategoryData.getListData());
        showRecylerList();


        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showRecylerList() {
        categories.setLayoutManager(new LinearLayoutManager(this));
        CategoryAdapter categoryadapter = new CategoryAdapter(this);
        categoryadapter.setCategoryList(list);
        categories.setAdapter(categoryadapter);
    }

}
