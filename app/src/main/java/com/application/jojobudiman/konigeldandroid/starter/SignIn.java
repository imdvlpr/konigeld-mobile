package com.application.jojobudiman.konigeldandroid.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.application.jojobudiman.konigeldandroid.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class SignIn extends AppCompatActivity {

    private Button login;
    private EditText email, pass;
    private TextView forgotpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signincredentials);

        login = (Button) findViewById(R.id.signin);
        email = (EditText) findViewById(R.id.emailText);
        pass = (EditText) findViewById(R.id.passwordText);
        forgotpass = (TextView) findViewById(R.id.forgetpass);


    }

    public void buLogin(View view) {
        String url="http://10.2.2:8888/semester8/konigeld/assets/mobile/login.php?email_user="+email.getText().toString()+"&pass_user="+pass.getText().toString();
        new getMySqlData().execute(url);
        Log.v("myApp", url); //Mengeluarkan di logcat
        //Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG).show();
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
                JSONObject json= new JSONObject(progress[0]);
                //JSONArray descWeather = json.getJSONArray("user"); //Memanggil JSONArray (Dari array object) dari data

                String id = json.getString("id_user");
                Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();


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