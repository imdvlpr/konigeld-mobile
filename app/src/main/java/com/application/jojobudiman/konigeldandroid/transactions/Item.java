package com.application.jojobudiman.konigeldandroid.transactions;
import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private String name, quantity, price;

    // Getter dan setter dari variable di class
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

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.quantity);
        dest.writeString(this.price);
    }

    Item() {
    }

    private Item(Parcel in) {
        this.name = in.readString();
        this.quantity = in.readString();
        this.price = in.readString();
    }
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }
        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}