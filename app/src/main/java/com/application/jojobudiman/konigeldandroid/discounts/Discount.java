package com.application.jojobudiman.konigeldandroid.discounts;

import android.os.Parcel;
import android.os.Parcelable;

public class Discount implements Parcelable {
    private String name;

    // Getter dan setter dari variable di class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    Discount() {
    }

    private Discount(Parcel in) {
        this.name = in.readString();
    }
    public static final Parcelable.Creator<Discount> CREATOR = new Parcelable.Creator<Discount>() {
        @Override
        public Discount createFromParcel(Parcel source) {
            return new Discount(source);
        }
        @Override
        public Discount[] newArray(int size) {
            return new Discount[size];
        }
    };
}
