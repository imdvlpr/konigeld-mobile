package com.application.jojobudiman.konigeldandroid.transactions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.checkout.CustomMenu;
import com.application.jojobudiman.konigeldandroid.products.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transactions extends Fragment {
    public Transactions() {


        // Required empty public constructor
    }

    private RecyclerView receipts;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private ReceiptAdapter receiptadapter;
    private List<Receipt> receiptList;
    private Activity activity;

    String url;
    ImageButton menubtn;
    LinearLayout paygains;
    protected Cursor cursor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String idout = sharedPreferences.getString("id_outlet", "defaultValue");
        url = "http://10.0.2.2:8888/semester8/konigeld/assets/mobile/select_hist.php?id_outlet="+idout;
        Log.v("myApp", url);//Mengeluarkan di logcat

        View view = inflater.inflate(R.layout.activity_transactions, container, false);
        Fragment fragment = new Transactions();
        final DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);


        menubtn = (ImageButton) view.findViewById(R.id.menu);
        receipts = (RecyclerView) view.findViewById(R.id.receiptList);
        receiptList = new ArrayList<>();
        receiptadapter = new ReceiptAdapter(getContext(), receiptList);

        linearLayoutManager = new LinearLayoutManager(this.getContext());
        dividerItemDecoration = new DividerItemDecoration(receipts.getContext(), linearLayoutManager.getOrientation());

        receipts.setHasFixedSize(true);
        receipts.setLayoutManager(linearLayoutManager);
        receipts.setAdapter(receiptadapter);

        getData();


        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });

        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this.getContext());
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
                        int id = jsonObject.getInt("id_order");
                        String tgl = jsonObject.getString("date");
                        String wkt = jsonObject.getString("waktu");
                        String ttl = jsonObject.getString("total_order");
                        //Log.v("TESTTTT", nama);
                        //Toast.makeText(getApplicationContext(), nama, Toast.LENGTH_LONG).show();
                        Receipt receipt = new Receipt(tgl, wkt, ttl);
                        receipt.setId(id);
                        receipt.setDate(tgl);
                        receipt.setTime(wkt);
                        receipt.setTotal("Rp " + ttl);
                        receiptList.add(receipt);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                receiptadapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        requestQueue.add(jsonArrayRequest);
    }


    /*
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.searchlayout, menu);
        SearchManager transactions = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
            SearchView transactionsearch = (SearchView) (menu.findItem(R.id.searchReceipt).getActionView());
            changeSearchViewColor(transactionsearch);
            ((EditText)transactionsearch.findViewById(R.id.searchReceipt)).setHintTextColor(getResources().getColor(R.color.colorPrimary));
            transactionsearch.setImeOptions(EditorInfo.IME_ACTION_DONE);
            transactionsearch.setSearchableInfo(transactions.getSearchableInfo(getActivity().getComponentName()));
            transactionsearch.setQueryHint(getResources().getString(R.string.searchtransactions));

            transactionsearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    if(transactionsearch.isIconified()) {
                        transactionsearch.setIconified(true);
                    }
                        transactionsearch.onActionViewCollapsed();
                        return false;

                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }

            });


    }

    private List<Receipt> filter(List<Receipt> hue, String query) {
        query = query.toLowerCase();
        final List<Receipt> filtered = new ArrayList<>();
        for (Receipt receipt : hue) {
            final String searchtext = receipt.getId();
            if (searchtext.startsWith(query)) {
                filtered.add(receipt);
            }
        }

        return filtered;
    }


    private void changeSearchViewColor(View view) {
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(getResources().getColor(R.color.colorPrimary));
                return;
            }

            else if (view instanceof ViewGroup) {
                ViewGroup viewGroup= (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    changeSearchViewColor(viewGroup.getChildAt(i));
                }

            }
        }
    }*/



    /*@Override
    public void onNoteClick(int position) {
        receiptList.get(position);
        Intent i = new Intent(getActivity(), ReceiptDetails.class);
        startActivity(i);
    }*/


    /*public void onItemClick(int position) {
        // The onClick implementation of the RecyclerView item click
        Intent i = new Intent(getActivity(), ReceiptDetails.class);
        startActivity(i);
    }*/

    /*private void showSelectedReceipt(Receipt receipt){
        // Toast message untuk menunjukkan kamu memilih nama apa
        Toast.makeText(this, "Kamu memilih " + receipt.getTotal(), Toast.LENGTH_SHORT).show();
    }*/

}

