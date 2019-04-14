package com.application.jojobudiman.konigeldandroid.checkout;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.checkout.adapters.FilterProductAdapter;
import com.application.jojobudiman.konigeldandroid.checkout.adapters.FilterSelect;
import com.application.jojobudiman.konigeldandroid.checkout.spinner.SpinnerList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainMenu2 extends Fragment implements FilterProductAdapter.OnNoteListener {


    public MainMenu2() {


        // Required empty public constructor
    }
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    String url, url2;
    SharedPreferences sess;
    Spinner viewDemo;
    private ArrayAdapter<SpinnerList>  templist;
    private RecyclerView productfilters;
    private List<FilterSelect> fillist;
    private ArrayList<SpinnerList> dashboard;
    private FilterProductAdapter konifilter;
    private FilterProductAdapter.OnNoteListener notes;
    ImageButton menu;
    Button charge;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String idout = sharedPreferences.getString("id_outlet", "defaultValue");
        url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/category.php?id_outlet="+idout;

        View view = inflater.inflate(R.layout.activity_library_menu, container, false);

        viewDemo = (Spinner) view.findViewById(R.id.viewElements);
        dashboard = new ArrayList<>();
        fillist = new ArrayList<>();

        getData();

        templist = new ArrayAdapter<SpinnerList>(this.getActivity(), android.R.layout.simple_spinner_item, dashboard);
        templist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewDemo.setAdapter(templist);




        productfilters = (RecyclerView) view.findViewById(R.id.filterList);
        konifilter = new FilterProductAdapter(getContext(), fillist, notes);
        linearLayoutManager = new LinearLayoutManager(this.getActivity());
        dividerItemDecoration = new DividerItemDecoration(productfilters.getContext(), linearLayoutManager.getOrientation());

        productfilters.setHasFixedSize(true);
        productfilters.setLayoutManager(linearLayoutManager);
        productfilters.addItemDecoration(dividerItemDecoration);
        productfilters.setAdapter(konifilter);

        viewDemo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                fillist.clear();
                String item = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

                if(item.equals("Products")) {
                    url2 = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/products.php?id_outlet="+idout;
                    getData2();
                }
                else if(item.equals("Modifiers")) {
                    url2 = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/modifier.php?id_outlet="+idout;
                    getData3();
                }
                else if(item.equals("Discounts")) {
                    url2 = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/discount.php?id_outlet="+idout;
                    getData4();
                }
                else {
                    url2 = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/custom.php?id_outlet="+idout+"&nm="+item;
                    Log.v("WOIWIWOIWOIWOIWO", url2);
                    getData5();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }

    public void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = 0; i <= 2; i++) {

                    if (i == 0) {
                        String ss = "Products";
                        int sss = 999999997;
                        SpinnerList spinner = new SpinnerList(ss, sss);
                        spinner.setSname(ss);
                        spinner.setSval(sss);
                        dashboard.add(spinner);
                    }
                    else if(i == 1) {
                        String ss = "Modifiers";
                        int sss = 999999998;
                        SpinnerList spinner = new SpinnerList(ss, sss);
                        spinner.setSname(ss);
                        spinner.setSval(sss);
                        dashboard.add(spinner);
                    }
                    else {
                        String ss = "Discounts";
                        int sss = 999999999;
                        SpinnerList spinner = new SpinnerList(ss, sss);
                        spinner.setSname(ss);
                        spinner.setSval(sss);
                        dashboard.add(spinner);
                    }
                }
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String nama = jsonObject.getString("nama_jenis");
                        int id = jsonObject.getInt("id_jenis");
                        SpinnerList spinner = new SpinnerList(nama, id);
                        spinner.setSname(nama);
                        spinner.setSval(id);

                        dashboard.add(spinner);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                templist.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this.getActivity());
        requestQueue.add(jsonArrayRequest);
    }

    public void getData2() {
        final ProgressDialog progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url2, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String nama = jsonObject.getString("nama_produk");
                        String hg = jsonObject.getString("harga");
                        int id = jsonObject.getInt("id_produk");
                        int harga = Integer.parseInt(hg);
                        FilterSelect filterSelect = new FilterSelect(nama, harga, id);
                        filterSelect.setFiltername(nama);
                        filterSelect.setFilterprice(harga);
                        filterSelect.setFilterid(id);

                        fillist.add(filterSelect);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                konifilter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this.getActivity());
        requestQueue.add(jsonArrayRequest);
    }

    public void getData3() {
        final ProgressDialog progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url2, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String nama = jsonObject.getString("nama_modifier");
                        String hg = jsonObject.getString("harga_modifier");
                        int id = jsonObject.getInt("id_modifier");
                        int harga = Integer.parseInt(hg);
                        FilterSelect filterSelect = new FilterSelect(nama, harga, id);
                        filterSelect.setFiltername(nama);
                        filterSelect.setFilterprice(harga);
                        filterSelect.setFilterid(id);

                        fillist.add(filterSelect);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                konifilter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this.getActivity());
        requestQueue.add(jsonArrayRequest);
    }

    public void getData4() {
        final ProgressDialog progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url2, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String nama = jsonObject.getString("nama_dis");
                        String hg = jsonObject.getString("dis");
                        int id = jsonObject.getInt("id_dis");
                        Double hg1 = Double.parseDouble(hg);
                        int harga = 0;
                        if(hg1 < 1) {
                            harga = (int) (hg1 * 100);
                        }
                        else {
                            harga = (int) (hg1 * 1);
                        }
                        FilterSelect filterSelect = new FilterSelect(nama, harga, id);
                        filterSelect.setFiltername(nama);
                        filterSelect.setFilterprice(harga);
                        filterSelect.setFilterid(id);

                        fillist.add(filterSelect);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                konifilter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this.getActivity());
        requestQueue.add(jsonArrayRequest);
    }

    public void getData5() {
        final ProgressDialog progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url2, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String nama = jsonObject.getString("nama_produk");
                        String hg = jsonObject.getString("harga");
                        int id = jsonObject.getInt("id_produk");
                        int harga = Integer.parseInt(hg);
                        FilterSelect filterSelect = new FilterSelect(nama, harga, id);
                        filterSelect.setFiltername(nama);
                        filterSelect.setFilterprice(harga);
                        filterSelect.setFilterid(id);

                        fillist.add(filterSelect);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                konifilter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this.getActivity());
        requestQueue.add(jsonArrayRequest);
    }

    /*public class ModifierSelect {
        public String modname;
        public Integer modID;

        public ModifierSelect(String modname) {
            this.modname = modname;
        }

        public String getModname() {
            return modname;
        }

    }

    public class DiscountSelect {
        public String discname, discprice;

        public DiscountSelect(String discname, String discprice) {
            this.discname = discname;
            this.discprice = discprice;
        }

        public String getDiscname() {
            return discname;
        }

        public String getDiscprice() {
            return discprice;
        }
    }

    public class CategoryProduct {
        public String catname;
        public Integer catID;

        public CategoryProduct(String catname, Integer catID) {
            this.catname = catname;
            this.catID = catID;
        }

        public String getCatname() {
            return catname;
        }

        public Integer getCatID() {
            return catID;
        }

    }*/

    @Override
    public void onNoteClick(int position) {
        fillist.get(position);
        //Insert code xdxd
    }

}

