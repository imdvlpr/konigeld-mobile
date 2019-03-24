package com.application.jojobudiman.konigeldandroid.categories;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {
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

    Category() {
    }

    private Category(Parcel in) {
        this.name = in.readString();
    }
    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }
        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}
