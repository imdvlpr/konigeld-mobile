package com.application.jojobudiman.konigeldandroid.checkout.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.app.ProgressDialog;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.discounts.Discount;
import com.application.jojobudiman.konigeldandroid.modifiers.Modifier;
import com.application.jojobudiman.konigeldandroid.products.Product;

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
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FilterProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<FilterSelect> productfilterz;
    private List<Product> produk;
    private List<Discount> diskon;
    private List<Modifier> paket;
    private OnNoteListener notes;
    SharedPreferences sess, sess2;
    String url, test;


    public FilterProductAdapter(Context context, List<FilterSelect> productfilterz, OnNoteListener notes) {
        this.context = context;
        this.productfilterz = productfilterz;
        this.notes = notes;
        sess = context.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        sess2 = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.filter_products, parent, false);
        return new ViewHolder(v, notes);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FilterSelect productfiltersss= productfilterz.get(position);

        ((ViewHolder)holder).fName.setText(productfiltersss.getFiltername());
        ((ViewHolder)holder).fPrice.setText("Rp "+productfiltersss.getFilterprice());
        diskon = new ArrayList<>();
        produk = new ArrayList<Product>();
        paket = new ArrayList<Modifier>();
        getDiskon();
        getPaket();
        getProduk();

    }


    public int getItemCount() {
        return productfilterz.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView fName;
        TextView fPrice;
        OnNoteListener note;

        public ViewHolder(View itemView, OnNoteListener note) {
            super(itemView);
            fName = itemView.findViewById(R.id.filter_producttext);
            fPrice = itemView.findViewById(R.id.filter_productprice);
            this.note = note;
            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            //note.onNoteClick(getAdapterPosition());
            //Toast.makeText(view.getContext(), "ITEM PRESSED = " + Integer.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            FilterSelect productf = productfilterz.get(getAdapterPosition());
            int id_produk = productf.getFilterid();
            String nama = productf.getFiltername();
            int hg = productf.getFilterprice();
            String aa = String.valueOf(hg);

            int dato = 0;

            Discount discount = new Discount(nama, "0");
            discount.setName(nama);
            discount.setDisc("0");

            Modifier modifier = new Modifier(nama);
            modifier.setName(nama);

            Product product = new Product(nama, "0");
            product.setName(nama);
            product.setPrice("Rp " + "0");

            SharedPreferences.Editor as = sess.edit();
            String tot = sess.getString("finn", "Rp 0");
            String idout = sess2.getString("id_outlet", "0");
            String id_user = sess2.getString("id", "defaultValue");
            String words[] = tot.split(" ");
            int hghg = Integer.parseInt(words[1]);
            int finl = hghg+hg;
            as.putString("finn", "Rp "+finl);
            as.putString("total", "Rp "+finl);
            as.apply();


            for(Discount model : diskon) {
                if(model.getName().equals(nama)) {
                    System.out.println(model.getName());
                    dato = 1;
                    url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/tempo.php?" +
                            "id_outlet="+idout+"&id_user="+id_user+"&id_produk=0&id_modifier=0" +
                            "&id_diskon="+id_produk+"&total=0";
                    break;
                }
                else {
                    System.out.println("GA ADA");
                }
            }

            if(dato == 0) {
                for(Modifier model : paket) {
                    if(model.getName().equals(nama)) {
                        System.out.println(model.getName());
                        dato = 1;
                        url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/tempo.php?" +
                                "id_outlet="+idout+"&id_user="+id_user+"&id_produk=0&id_modifier="+id_produk+
                                "&id_diskon=0&total=0";
                        break;
                    }
                    else {
                        System.out.println("GA ADA");
                    }
                }
            }

            if(dato == 0) {
                for(Product model : produk) {
                    if(model.getName().equals(nama)) {
                        System.out.println(model.getName());
                        dato = 1;
                        url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/tempo.php?" +
                                "id_outlet="+idout+"&id_user="+id_user+"&id_produk="+id_produk+"&id_modifier=0" +
                                "&id_diskon=0&total=0";
                        break;
                    }
                    else {
                        System.out.println("GA ADA");
                    }
                }
            }

            new getMySqlData().execute(url);
            Log.v("myApp", url);

            //Toast.makeText(context,"The Item Clicked is: "+getAdapterPosition(),Toast.LENGTH_SHORT).show();
        }

    }



    public interface OnNoteListener {
        void onNoteClick(int position);
    }

    public void getDiskon() {
        final ProgressDialog progressDialog = new ProgressDialog(this.context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        String idout = sess2.getString("id_outlet", "defaultValue");
        url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/discount.php?id_outlet="+idout;


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String nama = jsonObject.getString("nama_dis");
                        String harga = jsonObject.getString("dis");
                        Discount discount = new Discount(nama, "0");
                        discount.setName(nama);
                        discount.setDisc("0");
                        Log.v("XXXXXXXXXXXXXXXXXXXXXXXXXX   ", "MASUKIN "+nama);

                        diskon.add(discount);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this.context);
        requestQueue.add(jsonArrayRequest);

    }

    public void getPaket() {
        String idout = sess2.getString("id_outlet", "0");
        url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/modifier.php?id_outlet="+idout;

        final ProgressDialog progressDialog = new ProgressDialog(this.context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String nama = jsonObject.getString("nama_modifier");
                        Modifier modifier = new Modifier(nama);
                        modifier.setName(nama);

                        paket.add(modifier);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this.context);
        requestQueue.add(jsonArrayRequest);
    }

    public void getProduk() {
        String idout = sess2.getString("id_outlet", "0");
        url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/products.php?id_outlet="+idout;

        final ProgressDialog progressDialog = new ProgressDialog(this.context);
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

                        produk.add(product);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this.context);
        requestQueue.add(jsonArrayRequest);
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
