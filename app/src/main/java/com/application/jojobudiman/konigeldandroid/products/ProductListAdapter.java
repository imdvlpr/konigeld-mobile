package com.application.jojobudiman.konigeldandroid.products;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.CategoryViewHolder> {

    /*private OnItemClicked onClick;*/
    private Context context;
    private ArrayList<Product> getProductLists() {
        return ProductsList;
    }
    private OnNoteListener notes;

    public void setProductsList(ArrayList<Product> ProductsList) {
        this.ProductsList = ProductsList;
    }

    private ArrayList<Product> ProductsList;

    public ProductListAdapter(Context context) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.productlist, parent, false);
        return new CategoryViewHolder(itemRow, notes);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, final int position) {
        holder.pName.setText(getProductLists().get(position).getName());
        holder.pPrice.setText(getProductLists().get(position).getPrice());
    }



    @Override
    public int getItemCount() {
        return getProductLists().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView pName;
        TextView pPrice;
        OnNoteListener note;

        CategoryViewHolder(View itemView, OnNoteListener note) {
            super(itemView);
            pName = itemView.findViewById(R.id.producttext);
            pPrice = itemView.findViewById(R.id.productprice);
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
