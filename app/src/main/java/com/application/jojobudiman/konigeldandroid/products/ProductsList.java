package com.application.jojobudiman.konigeldandroid.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.application.jojobudiman.konigeldandroid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductsList extends AppCompatActivity {

    ImageButton menubtn;
    String url, url2;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private RecyclerView.Adapter adapter;
    private List<Product> productList;
    private List<Product> productList2;
    private ProductListAdapter productadapter;
    private RecyclerView pList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String idout = sharedPreferences.getString("id_outlet", "defaultValue");
        url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/products.php?id_outlet="+idout;
        url2 = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/category.php?id_outlet="+idout;


        //Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG).show();
        //new MySqlData().execute(url);
        Log.v("myApp", url);//Mengeluarkan di logcat

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        pList = (RecyclerView) findViewById(R.id.productList);

        productList = new ArrayList<>();
        productList2 = new ArrayList<>();
        productadapter = new ProductListAdapter(getApplicationContext(), productList);

        linearLayoutManager = new LinearLayoutManager(this);
        dividerItemDecoration = new DividerItemDecoration(pList.getContext(), linearLayoutManager.getOrientation());


        pList.setHasFixedSize(true);
        pList.setLayoutManager(linearLayoutManager);
        pList.addItemDecoration(dividerItemDecoration);
        pList.setAdapter(productadapter);

        getData();


        menubtn = (ImageButton) findViewById(R.id.menu);

       //showResults();
       //showRecylerList();

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
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        //JSONArray nama = jsonObject.getJSONArray("nama_produk");
                        //JSONArray harga = jsonObject.getJSONArray("harga");
                        String nama = jsonObject.getString("nama_produk");
                        String harga = jsonObject.getString("harga");
                        //Log.v("TESTTTT", nama);
                        //Toast.makeText(getApplicationContext(), nama, Toast.LENGTH_LONG).show();
                        Product product = new Product(nama, harga);
                        product.setName(nama);
                        product.setPrice("Rp " + harga);

                        productList.add(product);
                        productList2 = Arrays.asList(product);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                productadapter.notifyDataSetChanged();
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

    private void showResults() {
        /*for (int i = 0; i <= pro.length(); i++) {
            JSONObject desc = pro.getJSONObject(i);
            String nama = desc.getString("nama_produk");
            String hg = desc.getString("harga");
            listp.add(new Product(nama, hg));
        }*/
        //SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        //String jsonString = sharedPreferences.getString("jsonString", "");
        //Toast.makeText(getApplicationContext(), jsonString, Toast.LENGTH_LONG).show();
        /*try {
            JSONObject jsonObj = new JSONObject(jsonString);
            JSONArray pro = jsonObj.getJSONArray("item");
            for (int i = 0; i < pro.length(); i++) {
                JSONObject desc = pro.getJSONObject(i);
                String nama = desc.getString("nama_produk");
                String harga = desc.getString("harga");
                Toast.makeText(getApplicationContext(), nama, Toast.LENGTH_LONG).show();
                listp.add(new Product(nama, harga));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/


        /*try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONArray pro = jsonArray.getJSONArray(Integer.parseInt("item"));
            for (int i = 0; i < pro.length(); i++) {
                JSONObject desc = pro.getJSONObject(i);
                String nama = desc.getString("nama_produk");
                int id_p = desc.getInt("id_produk");
                String harga = desc.getString("harga");
                Toast.makeText(getApplicationContext(), nama, Toast.LENGTH_LONG).show();
                listp.add(new Product(nama, harga));
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
            //Toast.makeText(getApplicationContext(), "MASUK CATCH", Toast.LENGTH_LONG).show();
        }*/

        //listp = new ArrayList<>();

    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.searchlayout, menu);

            SearchView productsearch = (SearchView) (menu.findItem(R.id.searchProduct).getActionView());
            productsearch.setImeOptions(EditorInfo.IME_ACTION_DONE);

            productsearch.setQueryHint(getResources().getString(R.string.searchproduct));

            productsearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {

                    adapter.getFilter().filter(newText);
                    return false;
                }
            });

        return true;

    }*/

    /*public class MySqlData extends AsyncTask<String, String, String> {


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

        //TODO : Pindahkan ke doinbackground

        protected void onProgressUpdate(String... progress) { //Ambil 1 array yang dilakukan

        }

        protected void onPostExecute(String result){

            List<Product> data = new ArrayList<>();

            try {
                //listp = new ArrayList<>();
                //String[] idp = new String[100];

                //JSONArray descWeather = json.getJSONArray("user"); //Memanggil JSONArray (Dari array object) dari data

                JSONArray pro = new JSONArray(result);
                Log.v("myApp", "xxxx 2");//Mengeluarkan di logcat
                //ArrayList<String> list = new ArrayList<>();
                for(int i = 0; i < pro.length(); i++) {
                    Product product = new Product();
                    JSONObject desc = pro.getJSONObject(i);
                    product.name = desc.getString("nama_produk");
                    product.price = desc.getString("harga");
                    //Toast.makeText(getApplicationContext(), harga,Toast.LENGTH_LONG).show();
                    data.add(product);
                }


                //Log.v("myApp", "xxxxxxxxxxxxxxxxxxxxxxxxxxxx 3");//Mengeluarkan di logcat

                /*String jsonString = pro.toString();
                //Toast.makeText(getApplicationContext(), jsonString,Toast.LENGTH_LONG).show();

                SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("jsonString", jsonString);
                editor.apply();
                editor.commit();*/


            /*} catch (Exception ex) {
                Toast.makeText(getApplicationContext(),"Fail load API data",Toast.LENGTH_LONG).show();
            }

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
    }*/


}
