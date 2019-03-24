package com.application.jojobudiman.konigeldandroid.modifiers;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.application.jojobudiman.konigeldandroid.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ModifiersList extends AppCompatActivity {

    ImageButton menubtn;
    private RecyclerView Modifiers;
    private ArrayList<Modifier> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifiers);

        menubtn = (ImageButton) findViewById(R.id.menu);
        Modifiers = (RecyclerView) findViewById(R.id.modifierList);
        Modifiers.setHasFixedSize(true);
        list.addAll(ModifierData.getListData());
        showRecylerList();

        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void showRecylerList() {
        Modifiers.setLayoutManager(new LinearLayoutManager(this));
        ModifierAdapter modifieradapter = new ModifierAdapter(this);
        modifieradapter.setModifiersList(list);
        Modifiers.setAdapter(modifieradapter);
    }
}
