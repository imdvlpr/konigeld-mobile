package com.application.jojobudiman.konigeldandroid.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.checkout.PaymentSuccessEmailReceipt;

public class Products extends Fragment {

    public Products() {


        // Required empty public constructor
    }
    TextView prod, cat, mod, disc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_products, container, false);

        prod = (TextView) view.findViewById(R.id.allproducts);
        cat = (TextView) view.findViewById(R.id.categories);
        mod = (TextView) view.findViewById(R.id.modifiers);
        disc = (TextView) view.findViewById(R.id.discounts);
        final DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);

        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Products.class);
                startActivity(i);
            }
        });

        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
