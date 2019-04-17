package com.application.jojobudiman.konigeldandroid.transactions;
import android.os.Parcel;
import android.os.Parcelable;

public class Item {
    private String name, quantity, price;

    // Getter dan setter dari variable di class

    public Item(String name, String quantity, String price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}