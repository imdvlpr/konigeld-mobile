package com.application.jojobudiman.konigeldandroid.transactions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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

public class ReceiptDetails extends AppCompatActivity {

    ImageButton bacc;
    Button newrec, refund;
    ViewPager viewPager;
    private RecyclerView items;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Item> list;
    private ItemAdapter itemadapter;
    String url, ttt;
    TextView idnya, stotal, total;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_details);

        SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int id = sharedPreferences.getInt("ID_Hist", 0);
        Log.v("XXXXXXXXXXXXXXXXXXXXXXXXXXX IDNYA di detail", ""+id);
        //Toast.makeText(getApplicationContext(), ""+id, Toast.LENGTH_LONG).show();

        url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/select_data.php?id_order="+id;

        newrec = (Button) findViewById(R.id.newreceipt);
        refund = (Button) findViewById(R.id.issuerefund);
        bacc = (ImageButton) findViewById(R.id.menu);
        idnya = (TextView) findViewById(R.id.paymenttext);
        stotal = (TextView) findViewById(R.id.stotaltext);
        total = (TextView) findViewById(R.id.total);
        items = (RecyclerView) findViewById(R.id.itemsList);

        list = new ArrayList<>();
        itemadapter = new ItemAdapter(getApplicationContext(), list);

        linearLayoutManager = new LinearLayoutManager(this);
        dividerItemDecoration = new DividerItemDecoration(items.getContext(), linearLayoutManager.getOrientation());

        items.setHasFixedSize(true);
        items.setLayoutManager(linearLayoutManager);
        items.addItemDecoration(dividerItemDecoration);
        items.setAdapter(itemadapter);

        getData();

        total.setText("Rp "+ sharedPreferences.getString("totalnya", "0"));

        bacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("ID_Hist");
                finish();
            }
        });

        items = (RecyclerView) findViewById(R.id.itemsList);
        items.setHasFixedSize(true);

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

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count = 0;
                String[] nm = new String[200];
                String[] hg = new String[200];
                int[] quan = new int[200];
                String ttl = "0";
                for (int i = 0; i < response.length(); i++) {
                    try {
                        int counter = 0;
                        JSONObject jsonObject = response.getJSONObject(i);
                        String nama = jsonObject.getString("nama_produk");
                        String harga = jsonObject.getString("harga");
                        String nama_mod = jsonObject.getString("nama_modifier");
                        String nama_diskon = jsonObject.getString("nama_diskon");
                        Log.v("XXXXXXXXXXXXXXX PRODUK", nama_mod);
                        if(! nama.equals("null")) {
                            Log.v("XXXXXXXXXXXXXXX PRODUK", "SINI");
                            nm[i] = nama;
                            if(i == 0) {
                                nm[i] = nama;
                                quan[i] = 1;
                            }

                            for(int k = 0; k < i; k++) {
                                if(nm[k].equals(nm[i])) {
                                    quan[k]++;
                                    int hgg = Integer.parseInt(harga)*quan[k];
                                    hg[k] = String.valueOf(hgg);
                                    counter = 1;
                                    break;
                                }
                            }
                            if(counter == 0) {
                                nm[i] = nama;
                                quan[i] = 1;
                                hg[i] = harga;
                                count++;
                            }
                        }
                        else if(! nama_mod.equals("null")) {
                            Log.v("XXXXXXXXXXXXXXX MOD", "SINI");
                            String harga2 = jsonObject.getString("harga_modifier");
                            nm[i] = nama_mod;
                            if(i == 0) {
                                nm[i] = nama_mod;
                                quan[i] = 1;
                            }

                            for(int k = 0; k < i; k++) {
                                if(nm[k].equals(nm[i])) {
                                    quan[k]++;
                                    int hgg = Integer.parseInt(harga2)*quan[k];
                                    hg[k] = String.valueOf(hgg);
                                    counter = 1;
                                    break;
                                }
                            }
                            if(counter == 0) {
                                nm[i] = nama_mod;
                                quan[i] = 1;
                                hg[i] = harga2;
                                count++;
                            }
                        }
                        else if(! nama_diskon.equals("null")){
                            Log.v("XXXXXXXXXXXXXXX DISKON", "SINI");
                            String harga3 = jsonObject.getString("jumlah_diskon");
                            nm[i] = nama_diskon;
                            if(i == 0) {
                                nm[i] = nama_diskon;
                                quan[i] = 1;
                            }

                            for(int k = 0; k < i; k++) {
                                if(nm[k].equals(nm[i])) {
                                    quan[k]++;
                                    int hgg = Integer.parseInt(harga3)*quan[k];
                                    hg[k] = String.valueOf(hgg);
                                    counter = 1;
                                    break;
                                }
                            }
                            if(counter == 0) {
                                nm[i] = nama_diskon;
                                quan[i] = 1;
                                hg[i] = harga3;
                                count++;
                            }
                        }
                        else {
                            Log.v("XXXXXXXXXXXXXXX CUSTOM", "SINI");
                            nm[i] = "Custom Menu";
                            hg[i] = jsonObject.getString("total_order");
                            quan[i] = 1;
                            count++;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }

                for(int j = 0; j < count; j++) {
                    Item item = new Item(nm[j], String.valueOf(quan[j]), hg[j]);
                    item.setName(nm[j]);
                    item.setPrice("Rp " + hg[j]);
                    item.setQuantity(String.valueOf(quan[j]));
                    list.add(item);
                }
                itemadapter.notifyDataSetChanged();
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

    @Override
    public void onBackPressed()
    {
        finish();
    }
}
