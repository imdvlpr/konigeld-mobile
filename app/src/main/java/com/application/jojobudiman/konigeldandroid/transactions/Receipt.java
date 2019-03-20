package com.application.jojobudiman.konigeldandroid.transactions;
import android.os.Parcel;
import android.os.Parcelable;

public class Receipt implements Parcelable {
    private String total, date, time;

    // Getter dan setter dari variable di class
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.total);
        dest.writeString(this.date);
        dest.writeString(this.time);
    }

    Receipt() {
    }

    private Receipt(Parcel in) {
        this.total = in.readString();
        this.date = in.readString();
        this.time = in.readString();
    }
    public static final Parcelable.Creator<Receipt> CREATOR = new Parcelable.Creator<Receipt>() {
        @Override
        public Receipt createFromParcel(Parcel source) {
            return new Receipt(source);
        }
        @Override
        public Receipt[] newArray(int size) {
            return new Receipt[size];
        }
    };
}