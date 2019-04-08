package com.application.jojobudiman.konigeldandroid.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageButton;
import android.widget.Toast;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.starter.SignIn;
import com.application.jojobudiman.konigeldandroid.starter.WelcomeText;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ProductsList extends AppCompatActivity {

    ImageButton menubtn;
    private ProductListAdapter adapter;
    private RecyclerView products;
    private ArrayList<Product> listp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String idout = sharedPreferences.getString("id_outlet", "defaultValue");
        String url="http://10.0.2.2:8888/semester8/konigeld/assets/mobile/products.php?id_outlet="+idout;
        new getMySqlData().execute(url);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        menubtn = (ImageButton) findViewById(R.id.menu);
        products = (RecyclerView) findViewById(R.id.productList);
        products.setHasFixedSize(true);

       showResults();
       showRecylerList();

        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }


    private void showResults(ArrayList<Product> pro) {


        SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String jsonString = sharedPreferences.getString("jsonString", "");
        Toast.makeText(getApplicationContext(), jsonString, Toast.LENGTH_LONG).show();

        try {
            JSONObject jsonObj = new JSONObject(jsonString.toString());
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
        }


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

    private void showRecylerList() {
        products.setLayoutManager(new LinearLayoutManager(this));
        ProductListAdapter productadapter = new ProductListAdapter(this);
        productadapter.setProductsList(listp);
        products.setAdapter(productadapter);
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

        //TODO : Pindahkan ke doinbackground

        protected void onProgressUpdate(String... progress) { //Ambil 1 array yang dilakukan

            try {
                listp = new ArrayList<>();
                String[] idp = new String[100];

                JSONObject json= new JSONObject(progress[0]);
                //JSONArray descWeather = json.getJSONArray("user"); //Memanggil JSONArray (Dari array object) dari data

                JSONArray pro = json.getJSONArray("item");

                Log.v("myApp", "xxxx 2");//Mengeluarkan di logcat
                //ArrayList<Product> list = new ArrayList<>();
                for(int i = 0; i < pro.length(); i++) {
                    JSONObject desc = pro.getJSONObject(i);
                    String nama = desc.getString("nama_produk");
                    int id_p = desc.getInt("id_produk");
                    String harga = desc.getString("harga");
                    //ßToast.makeText(getApplicationContext(), nama,Toast.LENGTH_LONG).show();
                    String[][] data = new String[][]{
                            {nama, harga}
                    };
                    


                }

                String jsonString = pro.toString();
                //Toast.makeText(getApplicationContext(), jsonString,Toast.LENGTH_LONG).show();

                SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("jsonString", jsonString);
                editor.apply();
                editor.commit();


            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(),"Fail load API data",Toast.LENGTH_LONG).show();
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
