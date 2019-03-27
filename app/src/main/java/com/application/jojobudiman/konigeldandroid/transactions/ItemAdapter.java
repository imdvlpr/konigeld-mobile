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

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.CategoryViewHolder> {

    /*private OnItemClicked onClick;*/
    private Context context;
    private ArrayList<Item> getItemList() {
        return ItemList;
    }

    private OnNoteListener notes;


    public void setItemList(ArrayList<Item> ItemList) {
        this.ItemList = ItemList;
    }

    private ArrayList<Item> ItemList;

    public ItemAdapter(Context context) {
        this.context = context;
    }

    /*public interface OnItemClicked {
        void onItemClick(int position);
    }*/

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_container, parent, false);
        return new CategoryViewHolder(itemRow, notes);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, final int position) {
        holder.iName.setText(getItemList().get(position).getName());
        holder.iQuantity.setText(getItemList().get(position).getQuantity());
        holder.iPrice.setText(getItemList().get(position).getPrice());

    }



    @Override
    public int getItemCount() {
        return getItemList().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView iName;
        TextView iQuantity;
        TextView iPrice;
        OnNoteListener note;

        CategoryViewHolder(View itemView, OnNoteListener note) {
            super(itemView);
            iName = itemView.findViewById(R.id.itemname);
            iQuantity = itemView.findViewById(R.id.quantity);
            iPrice = itemView.findViewById(R.id.itemprice);
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