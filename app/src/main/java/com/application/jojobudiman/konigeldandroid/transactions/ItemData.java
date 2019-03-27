package com.application.jojobudiman.konigeldandroid.transactions;

import java.util.ArrayList;

public class ItemData {
    // Data2 yg akan didisplay
    public static String[][] data = new String[][]{
            {"Kopi Jovan", "x17", "Rp 20.000" }
    };

    // Method untuk return arrayList yg isinya data
    public static ArrayList<Item> getListData(){
        ArrayList<Item> list = new ArrayList<>();
        // For loop untuk melihat pecahan dr String Array
        for (String[] aData : data) {
            Item item = new Item();
            // Set pecahan dr String Array ke variable di Receipt
            item.setName(aData[0]);
            item.setQuantity(aData[1]);
            item.setPrice(aData[2]);
            // Add Receipt object ke ArrayList
            list.add(item);
        }
        return list;
    }

}

