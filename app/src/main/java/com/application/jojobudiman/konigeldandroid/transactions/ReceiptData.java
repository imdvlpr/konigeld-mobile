package com.application.jojobudiman.konigeldandroid.transactions;

import java.util.ArrayList;

public class ReceiptData {
    // Data2 yg akan didisplay
    public static String[][] data = new String[][]{
            {"SATURDAY, 9 FEBURARY 2019", "Rp 300.000.00", "03:48"},
            {"FRIDAY, 8 FEBURARY 2019", "Rp 350.000.00", "03:49"}
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
