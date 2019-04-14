package com.application.jojobudiman.konigeldandroid.products;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private Context context;
    private List<Product> products;

    public ProductListAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.productlist, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);

        holder.pName.setText(product.getName());
        holder.pPrice.setText(product.getPrice());
    }

    @Override
    public int getItemCount() {
        return products.size();

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView pName;
        TextView pPrice;

        public ViewHolder(View itemView) {
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
