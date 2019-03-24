package com.application.jojobudiman.konigeldandroid.discounts;

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

public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.CategoryViewHolder> {

    /*private OnItemClicked onClick;*/
    private Context context;
    private ArrayList<Discount> getDiscountList() {
        return DiscountList;
    }

    private OnNoteListener notes;


    public void setDiscountList(ArrayList<Discount> DiscountList) {
        this.DiscountList = DiscountList;
    }

    private ArrayList<Discount> DiscountList;

    public DiscountAdapter(Context context) {
        this.context = context;
        this.notes = notes;
    }

    /*public interface OnItemClicked {
        void onItemClick(int position);
    }*/

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.discountlist, parent, false);
        return new CategoryViewHolder(itemRow, notes);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, final int position) {
        holder.dName.setText(getDiscountList().get(position).getName());

        /*holder.rDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position);
            }
        });*/

    }



    @Override
    public int getItemCount() {
        return getDiscountList().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView dName;
        OnNoteListener note;

        CategoryViewHolder(View itemView, OnNoteListener note) {
            super(itemView);
            dName = itemView.findViewById(R.id.discountname);
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