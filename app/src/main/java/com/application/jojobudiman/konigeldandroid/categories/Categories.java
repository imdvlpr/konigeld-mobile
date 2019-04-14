package com.application.jojobudiman.konigeldandroid.categories;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.application.jojobudiman.konigeldandroid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Categories extends AppCompatActivity {

    ImageButton menubtn;
    private RecyclerView categories;
    private List<Category> categoryList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private CategoryAdapter categoryAdapter;


    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String idout = sharedPreferences.getString("id_outlet", "defaultValue");
        url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/category.php?id_outlet="+idout;
        Log.v("myApp", url);//Mengeluarkan di logcat


        menubtn = (ImageButton) findViewById(R.id.menu);

        categories = (RecyclerView) findViewById(R.id.categoryList);
        categoryList = new ArrayList<>();

        categoryAdapter = new CategoryAdapter(getApplicationContext(), categoryList);

        linearLayoutManager = new LinearLayoutManager(this);
        dividerItemDecoration = new DividerItemDecoration(categories.getContext(), linearLayoutManager.getOrientation());


        categories.setHasFixedSize(true);
        categories.setLayoutManager(linearLayoutManager);
        categories.addItemDecoration(dividerItemDecoration);
        categories.setAdapter(categoryAdapter);



        getData();


        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String nama = jsonObject.getString("nama_jenis");
                        Log.v("TESTTTT", nama);
                        Category category = new Category(nama);
                        category.setName(nama);

                        categoryList.add(category);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                categoryAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

}
