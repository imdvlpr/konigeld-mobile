package com.application.jojobudiman.konigeldandroid.discounts;

import android.os.Parcel;
import android.os.Parcelable;

public class Discount {
    private String name, disc;

    public Discount(String name, String disc) {
        this.name = name;
        this.disc = disc;
    }

    // Getter dan setter dari variable di class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }
}
