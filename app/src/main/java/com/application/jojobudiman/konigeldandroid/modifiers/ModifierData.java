package com.application.jojobudiman.konigeldandroid.modifiers;

import java.util.ArrayList;

public class ModifierData {
    // Data2 yg akan didisplay
    public static String[][] data = new String[][]{
            {"Paket A"},
            {"Paket B"},
            {"Paket C"}
    };

    // Method untuk return arrayList yg isinya data
    public static ArrayList<Modifier> getListData(){
        ArrayList<Modifier> list = new ArrayList<>();
        // For loop untuk melihat pecahan dr String Array
        for (String[] aData : data) {
            Modifier modifier = new Modifier();
            // Set pecahan dr String Array ke variable di Receipt
            modifier.setName(aData[0]);
            // Add Receipt object ke ArrayList
            list.add(modifier);

        }
        return list;
    }

}
