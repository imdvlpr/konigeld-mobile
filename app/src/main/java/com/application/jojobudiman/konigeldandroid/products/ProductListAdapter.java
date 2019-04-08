package com.application.jojobudiman.konigeldandroid.products;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
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
    ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Product> getProductLists() {
        return ProductsList;
    }

    public void setProductsList(ArrayList<Product> ProductsList) {
        this.ProductsList = ProductsList;
        this.products = products;
    }

    private ArrayList<Product> ProductsList;

    public ProductListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.productlist, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, final int position) {
        holder.pName.setText(getProductLists().get(position).getName());
        holder.pPrice.setText(getProductLists().get(position).getPrice());
    }



    @Override
    public int getItemCount() {
        return products.size();

    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView pName;
        TextView pPrice;

        CategoryViewHolder(View itemView) {
            super(itemView);
            pName = itemView.findViewById(R.id.producttext);
            pPrice = itemView.findViewById(R.id.productprice);
        }

    }

    /*public Filter getFilter() {
        return filtering;
    }

    private Filter filtering = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Product> flist = new ArrayList<>();

            if(constraint == null || constraint.length() == 0) {
                flist.addAll(listFull);
            }

            else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Product product : listFull) {
                    if(product.getName().toLowerCase().contains(filterPattern)) {
                        flist.add(product);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = flist;
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listFull.clear();
            listFull.addAll((ArrayList<Product>) results.values);
            notifyDataSetChanged();
        }
    };*/


}
