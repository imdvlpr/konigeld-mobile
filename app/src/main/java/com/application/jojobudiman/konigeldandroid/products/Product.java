package com.application.jojobudiman.konigeldandroid.products;
import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;

public class Product {

    public static String name;
    public String price;

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public static String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    // Getter dan setter dari variable di class

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}