package com.application.jojobudiman.konigeldandroid.transactions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.checkout.CustomMenu;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Transactions extends Fragment implements ReceiptAdapter.OnNoteListener {
    public Transactions() {


        // Required empty public constructor
    }

    private RecyclerView receipts;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private ReceiptAdapter receiptadapter;
    private List<Receipt> receiptList;
    private ReceiptAdapter.OnNoteListener notes;
    String url;
    ImageButton menubtn;
    LinearLayout paygains;
    protected Cursor cursor;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_transactions, container, false);
        Fragment fragment = new Transactions();
        final DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);


        menubtn = (ImageButton) view.findViewById(R.id.menu);
        receipts = (RecyclerView) view.findViewById(R.id.receiptList);
        receiptList = new ArrayList<>();
        receiptadapter = new ReceiptAdapter(getContext(), receiptList, notes);

        receipts.setHasFixedSize(true);
        receipts.setLayoutManager(linearLayoutManager);
        receipts.addItemDecoration(dividerItemDecoration);
        receipts.setAdapter(receiptadapter);


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

    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.searchlayout, menu);
        SearchManager transactions = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);

        if(getActivity() != null) {
            SearchView transactionsearch = (SearchView) (menu.findItem(R.id.searchReceipt).getActionView());
            transactionsearch.setImeOptions(EditorInfo.IME_ACTION_DONE);
            transactionsearch.setSearchableInfo(transactions.getSearchableInfo(getActivity().getComponentName()));
            transactionsearch.setQueryHint(getResources().getString(R.string.searchtransactions));

            transactionsearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

            }

        super.onCreateOptionsMenu(menu, inflater);
    }*/


    @Override
    public void onNoteClick(int position) {
        receiptList.get(position);
        Intent i = new Intent(getActivity(), ReceiptDetails.class);
        startActivity(i);
    }


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

