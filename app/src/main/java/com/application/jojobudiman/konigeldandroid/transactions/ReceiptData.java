package com.application.jojobudiman.konigeldandroid.transactions;

import java.util.ArrayList;

public class ReceiptData {
    // Data2 yg akan didisplay
    public static String[][] data = new String[][]{
            {"TUESDAY, 26 MARCH 2019", "Rp 300.000", "12:15"},
            {"MONDAY, 25 MARCH 2019", "Rp 250.000", "12:10"}
    };

    // Method untuk return arrayList yg isinya data
    public static ArrayList<Receipt> getListData(){
        ArrayList<Receipt> list = new ArrayList<>();
        // For loop untuk melihat pecahan dr String Array
        for (String[] aData : data) {
            Receipt receipt = new Receipt();
            // Set pecahan dr String Array ke variable di Receipt
            receipt.setDate(aData[0]);
            receipt.setTotal(aData[1]);
            receipt.setTime(aData[2]);
            // Add Receipt object ke ArrayList
            list.add(receipt);
        }
        return list;
    }

}
