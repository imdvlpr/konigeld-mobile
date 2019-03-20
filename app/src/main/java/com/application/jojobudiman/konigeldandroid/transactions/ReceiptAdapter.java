package com.application.jojobudiman.konigeldandroid.transactions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReceiptAdapter extends RecyclerView.Adapter<ReceiptAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<Receipt> getReceiptList() {
        return ReceiptList;
    }

    public void setReceiptList(ArrayList<Receipt> ReceiptList) {
        this.ReceiptList = ReceiptList;
    }

    private ArrayList<Receipt> ReceiptList;

    public ReceiptAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_receipts, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.rDate.setText(getReceiptList().get(position).getDate());
        holder.rTime.setText(getReceiptList().get(position).getTime());
        holder.rTotal.setText(getReceiptList().get(position).getTotal());

    }

    @Override
    public int getItemCount() {
        return getReceiptList().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView rDate;
        TextView rTime;
        TextView rTotal;

        CategoryViewHolder(View itemView) {
            super(itemView);
            rDate = itemView.findViewById(R.id.date);
            rTime = itemView.findViewById(R.id.time);
            rTotal = itemView.findViewById(R.id.amount);
        }
    }
}