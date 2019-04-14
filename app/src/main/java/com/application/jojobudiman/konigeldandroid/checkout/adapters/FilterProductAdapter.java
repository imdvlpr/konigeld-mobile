package com.application.jojobudiman.konigeldandroid.checkout.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.checkout.MainMenu2;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FilterProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<FilterSelect> productfilterz;
    private OnNoteListener notes;


    public FilterProductAdapter(Context context, List<FilterSelect> productfilterz, OnNoteListener notes) {
        this.context = context;
        this.productfilterz = productfilterz;
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.filter_products, parent, false);
        return new ViewHolder(v, notes);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FilterSelect productfiltersss= productfilterz.get(position);

        ((ViewHolder)holder).fName.setText(productfiltersss.getFiltername());
        ((ViewHolder)holder).fPrice.setText("Rp "+productfiltersss.getFilterprice());
    }


    public int getItemCount() {
        return productfilterz.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView fName;
        TextView fPrice;
        OnNoteListener note;

        public ViewHolder(View itemView, OnNoteListener note) {
            super(itemView);
            fName = itemView.findViewById(R.id.filter_producttext);
            fPrice = itemView.findViewById(R.id.filter_productprice);
            this.note = note;
            itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            note.onNoteClick(getAdapterPosition());
        }

    }



    public interface OnNoteListener {
        void onNoteClick(int position);
    }


    }
