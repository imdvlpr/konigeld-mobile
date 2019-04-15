package com.application.jojobudiman.konigeldandroid.checkout;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.checkout.adapters.FilterProductAdapter;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainMenu extends Fragment {

    public MainMenu() {


        // Required empty public constructor
    }
    SharedPreferences sess;
    ImageButton menu;
    Button charge;
    TextView calcoutput, konicontainer;
    Button one, two, three, four, five, six, seven, eight, nine, zero, clear, add;
    String a, url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.calculatorcount, container, false);
        View view2 = inflater.inflate(R.layout.activity_custom_menu, container, false);

        calcoutput = (TextView) view.findViewById(R.id.output);
        one = (Button) view.findViewById(R.id.onebtn);
        two = (Button) view.findViewById(R.id.twobtn);
        three = (Button) view.findViewById(R.id.threebtn);
        four = (Button) view.findViewById(R.id.fourbtn);
        five = (Button) view.findViewById(R.id.fivebtn);
        six = (Button) view.findViewById(R.id.sixbtn);
        seven = (Button) view.findViewById(R.id.sevenbtn);
        eight = (Button) view.findViewById(R.id.eightbtn);
        nine = (Button) view.findViewById(R.id.ninebtn);
        zero = (Button) view.findViewById(R.id.zerobtn);
        clear = (Button) view.findViewById(R.id.clearbtn);
        add = (Button) view.findViewById(R.id.addbtn);
        konicontainer = (TextView) view2.findViewById(R.id.konicont);
        charge = (Button) view2.findViewById(R.id.chargebtn);
        sess = this.getActivity().getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        SharedPreferences.Editor as = sess.edit();
        as.putString("total", "Rp ");
        as.apply();

        final int[] ans = {1};

        
        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a =  calcoutput.getText().toString();

                if (ans[0] == 1) { //
                    calcoutput.setText("Rp" + " " + "1");
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 1");
                    ans[0] = 0; //
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "1";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "2");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 2");
                    as.apply();
                }


                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "2";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "3");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 3");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "3";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "4");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 4");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "4";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "5");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 5");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "5";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "6");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 6");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "6";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "7");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 7");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "7";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "8");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 8");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "8";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "9");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 9");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "9";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                a = calcoutput.getText().toString();
                if (ans[0] == 1) {
                    a = "Rp";
                    calcoutput.setText("Rp" + " " + "0");
                    ans[0] = 0;
                    SharedPreferences.Editor as = sess.edit();
                    as.putString("total", "Rp 0");
                    as.apply();
                }

                else {
                    int length = calcoutput.getText().length();
                    if(length == 9) {
                        calcoutput.setText("Rp 999999");
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", "Rp 999999");
                        as.apply();
                    }
                    else {
                        a = a + "0";
                        calcoutput.setText(a);
                        SharedPreferences.Editor as = sess.edit();
                        as.putString("total", a);
                        as.apply();
                    }
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcoutput.setText("Rp" + " " + "0.00");
                ans[0] = 1;
                SharedPreferences.Editor as = sess.edit();
                as.putString("total", "Rp 0");
                as.apply();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
                String idout = sharedPreferences.getString("id_outlet", "defaultValue");
                String id_user = sharedPreferences.getString("id", "defaultValue");
                String to = sess.getString("total", "Rp 0");
                String finn = sess.getString("finn", "Rp 0");
                String words[] = to.split(" ");
                String fin = words[1];
                String words2[] = finn.split(" ");
                int tmbh = Integer.parseInt(fin);
                int awal = Integer.parseInt(words2[1]);
                //Toast.makeText(getContext(), ""+awal, Toast.LENGTH_LONG).show();
                if(awal == 0) {
                    as.putString("finn", "Rp "+fin);
                    as.apply();
                    calcoutput.setText("Rp" + " " + "0.00");
                    charge.setEnabled(false);
                    charge.setText("" + fin);
                    ans[0] = 1;
                    url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/tempo.php?" +
                            "id_outlet="+idout+"&id_user="+id_user+"&id_produk=0&id_modifier=0" +
                            "&id_diskon=0&total="+fin;

                }
                else {
                    int ak = awal+tmbh;
                    String fins = "Rp "+String.valueOf(ak);
                    as.putString("finn", fins);
                    as.apply();
                    calcoutput.setText("Rp" + " " + "0.00");
                    charge.setEnabled(false);
                    charge.setText("" + fin);
                    ans[0] = 1;
                    url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/tempo.php?" +
                            "id_outlet="+idout+"&id_user="+id_user+"&id_produk=0&id_modifier=0" +
                            "&id_diskon=0&total="+fin;
                }

                new getMySqlData().execute(url);
                Log.v("myApp", url);
            }
        });

        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_home, container, false);
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
