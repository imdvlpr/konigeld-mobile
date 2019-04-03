package com.application.jojobudiman.konigeldandroid.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.starter.SignIn;
import com.application.jojobudiman.konigeldandroid.starter.WelcomeText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ProductsList extends AppCompatActivity {

    ImageButton menubtn;
    private RecyclerView products;
    private ArrayList<Product> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        menubtn = (ImageButton) findViewById(R.id.menu);
        products = (RecyclerView) findViewById(R.id.productList);
        products.setHasFixedSize(true);
        list.addAll(ProductData.getListData());
        showRecylerList();

        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void showRecylerList() {
        products.setLayoutManager(new LinearLayoutManager(this));
        ProductListAdapter productadapter = new ProductListAdapter(this);
        productadapter.setProductsList(list);
        products.setAdapter(productadapter);
    }

    public class getMySqlData extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... params) {

            try {
                String NewsData;
                URL url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(7000);

                try {
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    NewsData = ConvertInputToStringNoChange(in);
                    publishProgress(NewsData);
                } finally {
                    urlConnection.disconnect();
                }

            }catch (Exception ex){

            }
            return null;
        }


        protected void onProgressUpdate(String... progress) { //Ambil 1 array yang dilakukan

            try {
                String[] idp = new String[100];
                JSONObject json= new JSONObject(progress[0]);
                //JSONArray descWeather = json.getJSONArray("user"); //Memanggil JSONArray (Dari array object) dari data

                JSONArray pro = json.getJSONArray("item");

                for(int i = 0; i < pro.length(); i++) {
                    JSONObject desc = pro.getJSONObject(i);
                    String nama = desc.getString("nama_produk");
                    Toast.makeText(getApplicationContext(), nama,Toast.LENGTH_LONG).show();

                }

                SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();


                //editor.apply();


            } catch (Exception ex) {
                //Toast.makeText(getApplicationContext(),"Fail load API data",Toast.LENGTH_LONG).show();
            }


        }

        protected void onPostExecute(String  result2){


        }


    }


    public static String ConvertInputToStringNoChange(InputStream inputStream) { //Menghilangkan string BufferReader

        BufferedReader bureader=new BufferedReader( new InputStreamReader(inputStream));
        String line ;
        String linereultcal="";

        try{
            while((line=bureader.readLine())!=null) {
                linereultcal+=line;

            }
            inputStream.close();


        }catch (Exception ex){}

        return linereultcal;
    }
}
