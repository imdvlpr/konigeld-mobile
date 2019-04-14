package com.application.jojobudiman.konigeldandroid.modifiers;
import android.os.Parcel;
import android.os.Parcelable;

public class Modifier {
    private String name;

    public Modifier(String name) {
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