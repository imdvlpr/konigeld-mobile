package com.application.jojobudiman.konigeldandroid.transactions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_receipts, parent, false);
        return new CategoryViewHolder(itemRow, notes);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, final int position) {
        holder.rDate.setText(getReceiptList().get(position).getDate());
        holder.rTime.setText(getReceiptList().get(position).getTime());
        holder.rTotal.setText(getReceiptList().get(position).getTotal());

        /*holder.rDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position);
            }
        });*/

    }



    @Override
    public int getItemCount() {
        return getReceiptList().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView rDate;
        TextView rTime;
        TextView rTotal;
        OnNoteListener note;

        CategoryViewHolder(View itemView, OnNoteListener note) {
            super(itemView);
            rDate = itemView.findViewById(R.id.date);
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

    public interface OnNoteListener {
        void onNoteClick(int position);
    }



}