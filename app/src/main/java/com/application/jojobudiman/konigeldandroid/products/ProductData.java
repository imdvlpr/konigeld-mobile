package com.application.jojobudiman.konigeldandroid.products;

import java.util.ArrayList;

public class ProductData {
    // Data2 yg akan didisplay
    public static String[][] data = new String[][]{
            {"Kopi Jovan", "Rp 20.000.00"},
            {"Kopi Enola", "Rp 20.000.00"}
    };

    // Method untuk return arrayList yg isinya data
    public static ArrayList<Product> getListData(){
        ArrayList<Product> list = new ArrayList<>();
        // For loop untuk melihat pecahan dr String Array
        for (String[] aData : data) {
            Product product = new Product();
            // Set pecahan dr String Array ke variable di Receipt
            product.setName(aData[0]);
            product.setPrice(aData[1]);
            // Add Receipt object ke ArrayList
            list.add(product);

        }
        return list;
    }

}
