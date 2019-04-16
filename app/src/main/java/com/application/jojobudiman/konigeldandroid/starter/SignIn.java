package com.application.jojobudiman.konigeldandroid.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


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
        String url="http://10.0.2.2:8888/semester8/konigeld/assets/mobile/login.php?email_user="+email.getText().toString()+"&pass_user="+pass.getText().toString();
        new getMySqlData().execute(url);
        Log.v("myApp", url);//Mengeluarkan di logcat
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
                String fname = json.getString("fname_user");
                String lname = json.getString("lname_user");
                String email_user = json.getString("email_user");
                String pw = json.getString("pass_user");
                String jabatan = json.getString("jabatan");
                String hp = json.getString("hp_user");
                String id_outlet = json.getString("id_outlet");
                String id_merchant = json.getString("id_merchant");
                String status = json.getString("status_user");
                String alamat = json.getString("alamat");
                String nb = json.getString("nama_bisnis");

                SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.clear();
                editor.commit();
                editor.putString("id", id);
                editor.putString("fname", fname);
                editor.putString("lname", lname);
                editor.putString("email", email_user);
                editor.putString("pw", pw);
                editor.putString("jabatan", jabatan);
                editor.putString("hp", hp);
                editor.putString("id_outlet", id_outlet);
                editor.putString("id_merchant", id_merchant);
                editor.putString("status", status);
                editor.putString("alamat", alamat);
                editor.putString("bisnis", nb);
                editor.apply();


                String pwd = md5(String.valueOf(pass.getText().toString()));

                if(email_user.equals(email.getText().toString()) && pwd.equals(pw)) {
                    Intent i = new Intent(getApplicationContext(), WelcomeText.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong Username or Password", Toast.LENGTH_LONG).show();
                }


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

    public String md5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        } catch(UnsupportedEncodingException ex){
        }
        return null;
    }


}