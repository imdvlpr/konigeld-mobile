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

public class ReceiptAdapter extends RecyclerView.Adapter<ReceiptAdapter.CategoryViewHolder> {

    /*private OnItemClicked onClick;*/
    private Context context;
    private ArrayList<Receipt> getReceiptList() {
        return ReceiptList;
    }
    private ArrayList<Receipt> listFull;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private OnNoteListener notes;


    public void setReceiptList(ArrayList<Receipt> ReceiptList) {
        this.ReceiptList = ReceiptList;
    }

    private ArrayList<Receipt> ReceiptList;

    public ReceiptAdapter(Context context, OnNoteListener notes) {
        this.context = context;
        this.notes = notes;
    }

    /*public interface OnItemClicked {
        void onItemClick(int position);
    }*/

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER) {
            View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_date, parent, false);
            return new CategoryViewHolder(itemRow, notes);
        }

        else {
            View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_receipts, parent, false);
            return new CategoryViewHolder(itemRow, notes);
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
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, final int position) {

        /*if (holder instanceof CategoryHeader) {

        }*/

        holder.rTime.setText(getReceiptList().get(position-1).getTime());
        holder.rTotal.setText(getReceiptList().get(position-1).getTotal());

        /*holder.rDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position);
            }
        });*/

    }



        /*holder.rDate.setText(getReceiptList().get(position).getDate());*/




    @Override
    public int getItemCount() {
        return getReceiptList().size() + 1;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView rTime;
        TextView rTotal;
        OnNoteListener note;

        CategoryViewHolder(View itemView, OnNoteListener note) {
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

    class CategoryHeader extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView rDate;
        OnNoteListener note;

        CategoryHeader(View itemView, OnNoteListener note) {
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