package com.application.jojobudiman.konigeldandroid.transactions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReceiptAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /*private OnItemClicked onClick;*/
    private Context context;
    private List<Receipt> receipts;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private OnNoteListener notes;


    public ReceiptAdapter(Context context, List<Receipt> receipts, OnNoteListener notes) {
        this.context = context;
        this.receipts = receipts;
        this.notes = notes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(context).inflate(R.layout.transaction_date, parent, false);
            return new ViewHeader(v, notes);
        }

        else {
            View v = LayoutInflater.from(context).inflate(R.layout.transaction_receipts, parent, false);
            return new ViewHolder(v, notes);
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }

        else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Receipt receipt = receipts.get(position);
        if(holder instanceof ViewHeader) {
            ((ViewHeader) holder).rDate.setText(receipt.getDate());
        } else if(holder instanceof ViewHolder) {
            ((ViewHolder) holder).rTime.setText(receipt.getTime());
            ((ViewHolder) holder).rTotal.setText(receipt.getTotal());

        }


    }


    @Override
    public int getItemCount() {
        return receipts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView rTime;
        TextView rTotal;
        OnNoteListener note;

        ViewHolder(View itemView, OnNoteListener note) {
            super(itemView);
            rTime = itemView.findViewById(R.id.time);
            rTotal = itemView.findViewById(R.id.amount);
            this.note = note;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            note.onNoteClick(getAdapterPosition());
        }

    }

    class ViewHeader extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView rDate;
        OnNoteListener note;

        public ViewHeader(View itemView, OnNoteListener note) {
            super(itemView);
            rDate = itemView.findViewById(R.id.date);
            this.note = note;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            note.onNoteClick(getAdapterPosition());
        }

    }

    public interface OnNoteListener {
        void onNoteClick(int position);
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