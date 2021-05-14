package com.example.jewelcart;
import java.util.ArrayList;


public class EarringsProvider {

    static String[] ids = {"ID: Earring1","ID: Earring2","ID: Earring3","ID: Earring4","ID: Earring5","ID: Earring6","ID: Earring7","ID: Earring8","ID: Earring9","ID: Earring10"};

    static String[] names = {"Ochre Hula Hoops", "Amber Disco Gum Drops", "Perforating Double Disc Drops",
            "Statement Vintage Chandelier", "Tropical Gunmetal Purple Sequin Flower",
            "Marquis Crystal Blossom Drop Earring", "Gold Diamante Waterfall Cupchains",
            "J Lili Swarovski Crystal Floral Drop", "Paua CZ Fancy Drop", "Filigree Leaf Drop"};

    static String[] prices = {"$60","$2120","$1950","$1750","$35","$1830","$790","$1060","$1185","$95"};

    static String[] materials = {"Material: 18c Gold Plated","Material: Yellow Gold","Material: Rose Gold","Material: White Gold","Material: Sequin","Material: White Gold",
            "Material: 22c Gold Plated","Material: Sterling Silver","Material: Sterling Silver","Material: 18c Gold Plated"};

    static String[] ratings = { "Rating: 2.6", "Rating: 2.3", "Rating: 5", "Rating: 3", "Rating: 4.2", "Rating: 4.7", "Rating: 3.2", "Rating: 3.1", "Rating: 3.9", "Rating: 4"};

    static int[][] imageaddress = {{R.drawable.earrings1_0,R.drawable.earrings1_1,R.drawable.earrings1_2}, {R.drawable.earrings2_0,R.drawable.earrings2_1,R.drawable.earrings2_2},
            {R.drawable.earrings3_0,R.drawable.earrings3_1,R.drawable.earrings3_2}, {R.drawable.earrings4_0,R.drawable.earrings4_1,R.drawable.earrings4_2},
            {R.drawable.earrings5_0,R.drawable.earrings5_1,R.drawable.earrings5_2}, {R.drawable.earrings6_0,R.drawable.earrings6_1,R.drawable.earrings6_2},
            {R.drawable.earrings7_0,R.drawable.earrings7_1,R.drawable.earrings7_2}, {R.drawable.earrings8_0,R.drawable.earrings8_1,R.drawable.earrings8_2},
            {R.drawable.earrings9_0,R.drawable.earrings9_1,R.drawable.earrings9_2}, {R.drawable.earrings10_0,R.drawable.earrings10_1,R.drawable.earrings10_2}};


    public static ArrayList<Products> generateData() {
        ArrayList<Products> earrings = new ArrayList<Products>();

        for (int i = 0; i < 10; i++) {

            String id = ids[i];
            String price = prices[i];
            String name = names[i];
            String material = materials[i];
            int[] picaddress = imageaddress[i];
            String currat = ratings[i];

            Products aEarring = new Products(id,picaddress,name,material,price,currat);
            earrings.add(aEarring);
        }
        return earrings;
    }
}
