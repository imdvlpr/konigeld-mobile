package com.application.jojobudiman.konigeldandroid.products;
import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private String name, price;

    // Getter dan setter dari variable di class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        dest.writeString(this.price);
    }

    Product() {
    }

    private Product(Parcel in) {
        this.name = in.readString();
        this.price = in.readString();
    }
    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }
        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}