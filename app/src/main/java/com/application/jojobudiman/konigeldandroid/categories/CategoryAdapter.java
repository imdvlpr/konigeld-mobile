package com.application.jojobudiman.konigeldandroid.categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    /*private OnItemClicked onClick;*/
    private Context context;
    private ArrayList<Category> getCategoryList() {
        return CategoryList;
    }

    private OnNoteListener notes;


    public void setCategoryList(ArrayList<Category> CategoryList) {
        this.CategoryList = CategoryList;
    }

    private ArrayList<Category> CategoryList;

    public CategoryAdapter(Context context) {
        this.context = context;
        this.notes = notes;
    }

    /*public interface OnItemClicked {
        void onItemClick(int position);
    }*/

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.categorylist, parent, false);
        return new CategoryViewHolder(itemRow, notes);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, final int position) {
        holder.dName.setText(getCategoryList().get(position).getName());

        /*holder.rDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position);
            }
        });*/

    }



    @Override
    public int getItemCount() {
        return getCategoryList().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView dName;
        OnNoteListener note;

        CategoryViewHolder(View itemView, OnNoteListener note) {
            super(itemView);
            dName = itemView.findViewById(R.id.categoryname);
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