package com.application.jojobudiman.konigeldandroid.products;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.application.jojobudiman.konigeldandroid.starter.SignIn;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;




/*public class ProductData extends Application {


    // Data2 yg akan didisplay
    public static String[][] data = new String[][]{

            {"Product A", "Rp 20.000"},
            {"Product B", "Rp 25.000"},
            {"Product C", "Rp 30.000"},
            {"Product D", "Rp 35.000"}
    };

    // Method untuk return arrayList yg isinya data
    Zublic static ArrayList<Product> getListData(){

        ArrayList<Product> list = new ArrayList<>();

        SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String idout = sharedPreferences.getString("id_outlet", "defaultValue");
        String url="http://10.0.2.2:8888/semester8/konigeld/assets/mobile/products.php?id_outlet="+idout;
        new getMySqlData().execute(url);
        Log.v("myApp", url);//Mengeluarkan di logcat
        Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG).show();*/
        // For loop untuk melihat pecahan dr String Array
        /*for (String[] aData : data) {
            Product product = new Product();
            // Set pecahan dr String Array ke variable di Receipt
            product.setName(aData[0]);
            product.setPrice(aData[1]);
            // Add Receipt object ke ArrayList
            list.add(product);

        }
        return list;
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
        }*/



