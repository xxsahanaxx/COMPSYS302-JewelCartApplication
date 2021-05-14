package com.example.jewelcart;
import java.util.ArrayList;

// Data provider class for Rings
public class RingsProvider {

    // Hardcoding item IDs as integers
    static String[] ids = {"ID: Ring1","ID: Ring2","ID: Ring3","ID: Ring4","ID: Ring5","ID: Ring6","ID: Ring7","ID: Ring8","ID: Ring9","ID: Ring10"};

    // Hardcoding names for each item
    static String[] names = {"Alessandro Divine Solitaire", "May Sunrise Solitaire", "Malala Ombre Solitaire",
            "Shea Mercury Solitaire", "Vintage Essence Multi-Halo", "Cynthia Magnifica Halo", "Evia Crown Solitaire",
            "Lumina Ambercoat Floral Crystal", "Taylor Magnum Halo", "Balenciaga Eskimo Multi-Halo"};

    static String[] prices = {"$1300", "$2230","$1500","$1600","$1800","$1900","$2100","$1200","$2300","$2340"};

    static String[] materials = {"Material: Yellow Gold", "Material: Yellow Gold", "Material: White Gold", "Material: White Gold",
            "Material: White Gold", "Material: White Gold", "Material: Rose Gold", "Material: Rose Gold", "Material: Platinum", "Material: Platinum"};
    static String[] ratings = {"Rating: 3", "Rating: 4", "Rating: 2.3", "Rating: 5", "Rating: 4.2", "Rating: 3.9", "Rating: 4.7", "Rating: 3.2", "Rating: 2.6", "Rating: 3.1"};

    // Sizes of rings (each size number corresponds to a particular measurement)
    static String[] dimensions = {"6.5f", "7f", "7.5f", "8f", "8.5f", "9f", "9.5f", "10f", "10.5f", "11f"};

    // a 2d integer array consisting of 3 images per id number (size of array is [10][3])
    static int[][] imageaddress = {{R.drawable.rings1_0,R.drawable.rings1_1,R.drawable.rings1_2}, {R.drawable.rings2_0,R.drawable.rings2_1,R.drawable.rings2_2},
            {R.drawable.rings3_0,R.drawable.rings3_1,R.drawable.rings3_2}, {R.drawable.rings4_0,R.drawable.rings4_1,R.drawable.rings4_2},
            {R.drawable.rings5_0,R.drawable.rings5_1,R.drawable.rings5_2}, {R.drawable.rings6_0,R.drawable.rings6_1,R.drawable.rings6_2},
            {R.drawable.rings7_0,R.drawable.rings7_1,R.drawable.rings7_2}, {R.drawable.rings8_0,R.drawable.rings8_1,R.drawable.rings8_2},
            {R.drawable.rings9_0,R.drawable.rings9_1,R.drawable.rings9_2}, {R.drawable.rings10_0,R.drawable.rings10_1,R.drawable.rings10_2}};


    public static ArrayList<Products> generateData() {
        ArrayList<Products> rings = new ArrayList<Products>();

        for (int i = 0; i < 10; i++) {

            String id = ids[i];
            String price = prices[i];
            String name = names[i];
            String material = materials[i];
            int[] picaddress = imageaddress[i];
            String currat = ratings[i];
            //String []curdim = dimensions;

            Products aRing = new Products(id,picaddress,name,material,price,currat);
            rings.add(aRing);
        }

        return rings;
    }
}
