package com.application.jojobudiman.konigeldandroid.checkout.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

public class SpinnerDropdown extends ArrayAdapter<SpinnerList> {

    private Context context;
    private List<SpinnerList> spinnerr;

    public SpinnerDropdown(@NonNull Context context, ArrayList<SpinnerList> spinnerr) {
        super(context, 0, spinnerr);
        this.context = context;
        this.spinnerr = spinnerr;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.spinnerlist, parent, false);
        TextView names = (TextView) view.findViewById(R.id.spinnername);
        names.setText(spinnerr.get(position).getSname());
        return view;
    }


}
