package com.application.jojobudiman.konigeldandroid.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.categories.Categories;
import com.application.jojobudiman.konigeldandroid.checkout.PaymentSuccessEmailReceipt;
import com.application.jojobudiman.konigeldandroid.discounts.Discounts;
import com.application.jojobudiman.konigeldandroid.modifiers.ModifiersList;

import java.util.ArrayList;

public class Products extends Fragment {


    public Products() {


        // Required empty public constructor
    }

    ImageButton menubtn;
    TextView prod, cat, mod, disc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_products, container, false);
        menubtn = (ImageButton) view.findViewById(R.id.menu);

        prod = (TextView) view.findViewById(R.id.allproducts);
        cat = (TextView) view.findViewById(R.id.categories);
        mod = (TextView) view.findViewById(R.id.modifiers);
        disc = (TextView) view.findViewById(R.id.discounts);
        final DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);


        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ProductsList.class);
                startActivity(i);
            }
        });

        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Categories.class);
                startActivity(i);
            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ModifiersList.class);
                startActivity(i);
            }
        });

        disc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Discounts.class);
                startActivity(i);
            }
        });

        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });




        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
