package com.application.jojobudiman.konigeldandroid.discounts;


import java.util.ArrayList;

public class DiscountData {
    // Data2 yg akan didisplay
    public static String[][] data = new String[][]{
            {"Paket A"},
            {"Paket B"},
            {"Paket C"}
    };

    // Method untuk return arrayList yg isinya data
    public static ArrayList<Discount> getListData(){
        ArrayList<Discount> list = new ArrayList<>();
        // For loop untuk melihat pecahan dr String Array
        for (String[] aData : data) {
            Discount discount = new Discount();
            // Set pecahan dr String Array ke variable di Receipt
            discount.setName(aData[0]);
            // Add Receipt object ke ArrayList
            list.add(discount);

        }
        return list;
    }

}