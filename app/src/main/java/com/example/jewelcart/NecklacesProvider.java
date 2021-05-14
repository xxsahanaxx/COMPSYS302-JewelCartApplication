package com.example.jewelcart;
import java.util.ArrayList;

public class NecklacesProvider {

    static String[] ids = {"ID: Necklace1","ID: Necklace2","ID: Necklace3","ID: Necklace4","ID: Necklace5","ID: Necklace6","ID: Necklace7","ID: Necklace8","ID: Necklace9","ID: Necklace10"};

    static String[] names = {"Crystal Triple Tear Drop", "Linked Gold Chain", "Mystic Morganite", "Akoya Polished Pearl", "Cushion Cut Watermelon Mint", "Isabella Rosemary Crystals", "Queen Mary I", "Round Brilliant Diamond", "Winter Morning Dew", "Gold Angel Wing"};

    static String[] prices = {"$2500", "$2250","$1800","$2600","$2850","$1830","$1790","$1530","$2720","$2030"};

    static String[] materials = {"Material: Platinum","Material: Yellow Gold","Material: Rose Gold","Material: Freshwater Pearl","Material: White Gold","Material: White Gold", "Material: White Gold","Material: Platinum","Material: Platinum","Material: White Gold"};
    static String[] ratings = {"Rating: 2.3", "Rating: 3","Rating: 4.2", "Rating: 2.6", "Rating: 4.7", "Rating: 3.9", "Rating: 4", "Rating: 5", "Rating: 3.2", "Rating: 3.1"};

    static String[] stoneNames = {"Solitaire","None","Morganite","Pearl","Tourmaline","Amethyst","Ruby","Diamond","Aquamarine","None"};
    static int[][] imageaddress = {{R.drawable.necklaces1_0,R.drawable.necklaces1_1,R.drawable.necklaces1_2}, {R.drawable.necklaces2_0,R.drawable.necklaces2_1,R.drawable.necklaces2_2},
            {R.drawable.necklaces3_0,R.drawable.necklaces3_1,R.drawable.necklaces3_2}, {R.drawable.necklaces4_0,R.drawable.necklaces4_1,R.drawable.necklaces4_2},
            {R.drawable.necklaces5_0,R.drawable.necklaces5_1,R.drawable.necklaces5_2}, {R.drawable.necklaces6_0,R.drawable.necklaces6_1,R.drawable.necklaces6_2},
            {R.drawable.necklaces7_0,R.drawable.necklaces7_1,R.drawable.necklaces7_2}, {R.drawable.necklaces8_0,R.drawable.necklaces8_1,R.drawable.necklaces8_2},
            {R.drawable.necklaces9_0,R.drawable.necklaces9_1,R.drawable.necklaces9_2}, {R.drawable.necklaces10_0,R.drawable.necklaces10_1,R.drawable.necklaces10_2}};


    public static ArrayList<Products> generateData() {
        ArrayList<Products> necklaces = new ArrayList<Products>();


        for (int i = 0; i < 10; i++) {

            String id = ids[i];
            String price = prices[i];
            String name = names[i];
            String material = materials[i];
            int[] picaddress = imageaddress[i];
            String currat = ratings[i];
            //String curstone = stoneNames[i];

            Products aNecklace = new Products(id,picaddress,name,material,price,currat);
            necklaces.add(aNecklace);
        }
        return necklaces;
    }
}
