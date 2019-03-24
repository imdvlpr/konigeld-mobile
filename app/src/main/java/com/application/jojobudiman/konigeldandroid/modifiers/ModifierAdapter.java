package com.application.jojobudiman.konigeldandroid.modifiers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModifierAdapter extends RecyclerView.Adapter<ModifierAdapter.CategoryViewHolder> {

    /*private OnItemClicked onClick;*/
    private Context context;
    private ArrayList<Modifier> getModifiers() {
        return ModifiersList;
    }
    private OnNoteListener notes;

    public void setModifiersList(ArrayList<Modifier> ModifiersList) {
        this.ModifiersList = ModifiersList;
    }

    private ArrayList<Modifier> ModifiersList;

    public ModifierAdapter(Context context) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.modifierlist, parent, false);
        return new CategoryViewHolder(itemRow, notes);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, final int position) {
        holder.mName.setText(getModifiers().get(position).getName());
    }



    @Override
    public int getItemCount() {
        return getModifiers().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mName;
        OnNoteListener note;

        CategoryViewHolder(View itemView, OnNoteListener note) {
            super(itemView);
            mName = itemView.findViewById(R.id.modifiername);
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
