package com.application.jojobudiman.konigeldandroid.products;

import android.content.Context;
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
        return ProductLists;
    }

    public void setProductsList(ArrayList<Product> ProductsList) {
        this.ProductLists = ProductLists;
    }

    private ArrayList<Product> ProductLists;

    public ProductListAdapter(Context context) {
        this.context = context;
    }

    /*public interface OnItemClicked {
        void onItemClick(int position);
    }*/

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_products_list, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, final int position) {
        holder.rName.setText(getProductLists().get(position).getName());
        holder.rPrice.setText(getProductLists().get(position).getPrice());

        /*holder.rDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position);
            }
        });*/

    }



    @Override
    public int getItemCount() {
        return getProductLists().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView rName;
        TextView rPrice;

        CategoryViewHolder(View itemView) {
            super(itemView);
            rName = itemView.findViewById(R.id.productt);
            rPrice = itemView.findViewById(R.id.productprice);
        }
    }



}
