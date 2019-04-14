package com.application.jojobudiman.konigeldandroid.modifiers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModifierAdapter extends RecyclerView.Adapter<ModifierAdapter.ViewHolder> {

    /*private OnItemClicked onClick;*/
    private Context context;
    private List<Modifier> modifiers;

    public ModifierAdapter(Context context, List<Modifier> modifiers) {
        this.context = context;
        this.modifiers = modifiers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.modifierlist, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Modifier modifier = modifiers.get(position);

        holder.mName.setText(modifier.getName());
    }



    @Override
    public int getItemCount() {
        return modifiers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mName;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.modifiername);
        }
    }
}
