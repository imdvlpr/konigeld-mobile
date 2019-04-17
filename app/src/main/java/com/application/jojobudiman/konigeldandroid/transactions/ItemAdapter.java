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

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /*private OnItemClicked onClick;*/
    private Context context;
    private List<Item> items;
    private OnNoteListener notes;


    public ItemAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    /*public interface OnItemClicked {
        void onItemClick(int position);
    }*/

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_container, parent, false);
        return new ViewHolder(itemRow, notes);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = items.get(position);
        ((ViewHolder) holder).iName.setText(item.getName());
        ((ViewHolder) holder).iQuantity.setText(item.getQuantity());
        ((ViewHolder) holder).iPrice.setText(item.getPrice());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView iName;
        TextView iQuantity;
        TextView iPrice;
        OnNoteListener note;

        ViewHolder(View itemView, OnNoteListener note) {
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