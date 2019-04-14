package com.application.jojobudiman.konigeldandroid.categories;

import android.os.Parcel;
import android.os.Parcelable;

public class Category {
    public String name;

    public Category(String name) {
        this.name = name;
    }

    // Getter dan setter dari variable di class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
