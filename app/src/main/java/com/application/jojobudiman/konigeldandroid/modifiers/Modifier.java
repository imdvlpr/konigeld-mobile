package com.application.jojobudiman.konigeldandroid.modifiers;
import android.os.Parcel;
import android.os.Parcelable;

public class Modifier implements Parcelable {
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

    Modifier() {
    }

    private Modifier(Parcel in) {
        this.name = in.readString();
    }
    public static final Creator<Modifier> CREATOR = new Creator<Modifier>() {
        @Override
        public Modifier createFromParcel(Parcel source) {
            return new Modifier(source);
        }
        @Override
        public Modifier[] newArray(int size) {
            return new Modifier[size];
        }
    };
}