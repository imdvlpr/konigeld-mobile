package com.application.jojobudiman.konigeldandroid.transactions;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.application.jojobudiman.konigeldandroid.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReceiptAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Receipt> receipts;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;



    public ReceiptAdapter(Context context, List<Receipt> receipts) {
        this.context = context;
        this.receipts = receipts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(context).inflate(R.layout.transaction_date, parent, false);
            return new ViewHeader(v);
        }

        else {
            View v = LayoutInflater.from(context).inflate(R.layout.transaction_receipts, parent, false);
            return new ViewHolder(v);
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }

        else {
            Receipt receipt = receipts.get(position);
            String tgl = receipt.getDate();

            Receipt receipt2 = receipts.get(position-1);
            String tgl2 = receipt2.getDate();

            if(tgl2.equals(tgl)) {
                return TYPE_ITEM;
            }
            else {
                return TYPE_HEADER;
            }

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Receipt receipt = receipts.get(position);
        if(holder instanceof ViewHeader) {
            ((ViewHeader) holder).rDate.setText(receipt.getDate());
            ((ViewHeader) holder).rTime.setText(receipt.getTime());
            ((ViewHeader) holder).rAmount.setText(receipt.getTotal());


        } else if(holder instanceof ViewHolder) {
            ((ViewHolder) holder).rTime.setText(receipt.getTime());
            ((ViewHolder) holder).rTotal.setText(receipt.getTotal());
        }


    }


    @Override
    public int getItemCount() {
        return receipts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView rTime;
        TextView rTotal;

        ViewHolder(View itemView) {
            super(itemView);
            rTime = itemView.findViewById(R.id.time);
            rTotal = itemView.findViewById(R.id.amount);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            Log.v("XXXXXXXXXXXXXXXXXXXXXXXXXXX", ""+getAdapterPosition());
            Receipt receipt = receipts.get(getAdapterPosition());
            SharedPreferences sharedPreferences = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            int id = receipt.getId();
            editor.remove("ID_Hist");
            editor.apply();
            Log.v("XXXXXXXXXXXXXXXXXXXXXXXXXXX IDNYA", ""+id);
            editor.putInt("ID_Hist", id);
            String ttl = receipt.getTotal();
            editor.putString("totalnya", ttl);
            editor.apply();
            Context context = view.getContext();
            Intent i = new Intent(context, ReceiptDetails.class);
            context.startActivity(i);
        }
    }

    public void setFilter(List<Receipt> receiptss) {
        receipts = new ArrayList<>();
        receipts.addAll(receiptss);
        notifyDataSetChanged();
    }

    class ViewHeader extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView rDate;
        TextView rTime;
        TextView rAmount;
        LinearLayout header, dates;


        public ViewHeader(View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.transaction_header_date);
            dates = itemView.findViewById(R.id.transaction_date);
            rDate = itemView.findViewById(R.id.date);
            rTime = itemView.findViewById(R.id.time);
            rAmount = itemView.findViewById(R.id.amount);

            header.setClickable(false);
            header.setFocusable(false);
            dates.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.v("XXXXXXXXXXXXXXXXXXXXXXXXXXX", ""+getAdapterPosition());
            Receipt receipt = receipts.get(getAdapterPosition());
            SharedPreferences sharedPreferences = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("ID_Hist");
            editor.apply();
            int id = receipt.getId();
            String ttl = receipt.getTotal();
            //Log.v("XXXXXXXXXXXXXXXXXXXXXXXXXXX IDNYA", ""+id);
            editor.putInt("ID_Hist", id);
            editor.putString("totalnya", ttl);
            editor.apply();
            Context context = view.getContext();
            Intent i = new Intent(context, ReceiptDetails.class);
            context.startActivity(i);
        }

    }

    /*public Filter getFilter() {
        return filtering;
    }

    private Filter filtering = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Receipt> list = new ArrayList<>();

            if(constraint == null || constraint.length() == 0) {
                list.addAll(listFull);
            }

            else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Receipt receipt : listFull) {
                    if(receipt.getId().toLowerCase().contains(filterPattern)) {
                        list.add(receipt);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values= list;
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listFull.clear();
            listFull.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };*/



}