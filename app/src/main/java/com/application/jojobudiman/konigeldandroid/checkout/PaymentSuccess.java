package com.application.jojobudiman.konigeldandroid.checkout;

import androidx.appcompat.app.AppCompatActivity;
import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.checkout.adapters.FilterProductAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PaymentSuccess extends AppCompatActivity {

    private TextView newsale, norec, ch;
    private ImageView emailsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);

        newsale = (TextView) findViewById(R.id.newsale);
        emailsend = (ImageView) findViewById(R.id.emailme);
        norec = (TextView) findViewById(R.id.noReceipt);
        ch = (TextView) findViewById(R.id.change);

        final SharedPreferences sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        int total = sharedPreferences.getInt("bayar", 0);
        String tot = sharedPreferences.getString("total", "defaultValue");
        String words[] = tot.split(" ");

        String jmlh = words[1];
        int byr = Integer.parseInt(jmlh);
        int chang = total - byr;
        //Toast.makeText(getApplicationContext(), ""+total, Toast.LENGTH_LONG).show();
        if(chang == 0) {
            ch.setText("No change out of Rp "+jmlh);
        }
        else {
            ch.setText("Rp "+chang+" change out of Rp "+total);
        }


        emailsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PaymentSuccessEmailReceipt.class);
                startActivity(i);
            }
        });


        newsale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("bayar");
                editor.remove("total");
                editor.remove("finn");
                editor.commit();

                SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
                String idout = sharedPreferences.getString("id_outlet", "default");
                String id_user = sharedPreferences.getString("id", "default");
                String url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/order.php?id_outlet="+idout+"&id_user="+id_user;
                new getMySqlData().execute(url);
                Log.v("myApp", url);

                Intent i = new Intent(getApplicationContext(), MainFragment.class);
                startActivity(i);
            }
        });

        norec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
                String idout = sharedPreferences.getString("id_outlet", "default");
                String id_user = sharedPreferences.getString("id", "default");
                String url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/order.php?id_outlet="+idout+"&id_user="+id_user;
                new getMySqlData().execute(url);
                Log.v("myApp", url);
                Intent i = new Intent(getApplicationContext(), PaymentSuccessNoReceipt.class);
                startActivity(i);
            }
        });


    }

    public class getMySqlData extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            //before works
        }

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

            }catch (Exception ex){}
            return null;
        }


        protected void onProgressUpdate(String... progress) {

            try {
                JSONObject json= new JSONObject(progress[0]);





            } catch (Exception ex) {

            }


        }

        protected void onPostExecute(String  result2){


        }



    }


    public static String ConvertInputToStringNoChange(InputStream inputStream) {

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
