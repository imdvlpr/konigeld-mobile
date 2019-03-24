package com.application.jojobudiman.konigeldandroid.categories;


import java.util.ArrayList;

public class CategoryData {
    // Data2 yg akan didisplay
    public static String[][] data = new String[][]{
            {"Paket A"},
            {"Paket B"},
            {"Paket C"}
    };

    // Method untuk return arrayList yg isinya data
    public static ArrayList<Category> getListData(){
        ArrayList<Category> list = new ArrayList<>();
        // For loop untuk melihat pecahan dr String Array
        for (String[] aData : data) {
            Category Category = new Category();
            // Set pecahan dr String Array ke variable di Receipt
            Category.setName(aData[0]);
            // Add Receipt object ke ArrayList
            list.add(Category);

        }
        return list;
    }

}