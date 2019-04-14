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

public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.ViewHolder> {

    /*private OnItemClicked onClick;*/
    private Context context;
    private List<Discount> discounts;

    public DiscountAdapter(Context context, List<Discount> discounts) {
        this.context = context;
        this.discounts = discounts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.discountlist, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Discount discount = discounts.get(position);

        holder.dName.setText(discount.getName());
        holder.dPrice.setText(discount.getDisc());
    }



    @Override
    public int getItemCount() {
        return discounts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView dName, dPrice;

        ViewHolder(View itemView) {
            super(itemView);
            dName = itemView.findViewById(R.id.discountname);
            dPrice = itemView.findViewById(R.id.discountprice);

        }

    }

}