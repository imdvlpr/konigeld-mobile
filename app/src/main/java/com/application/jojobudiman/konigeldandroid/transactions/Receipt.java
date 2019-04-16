package com.application.jojobudiman.konigeldandroid.transactions;
import android.os.Parcel;
import android.os.Parcelable;

public class Receipt {
    private int id;
    private String total, date, time;

    public Receipt(String date, String time, String total) {
        this.date = date;
        this.time = time;
        this.total = total;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}