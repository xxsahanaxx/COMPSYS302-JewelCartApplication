package com.example.jewelcart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecycleAdapter recycleAdapter;
    ArrayList<String> namesList;
    ArrayList<Products> aRings, aNecklaces, aEarrings, allProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namesList = new ArrayList<String>();
        allProducts = new ArrayList<Products>();

        // Creating ring objects
        aRings = new ArrayList<Products>();
        aRings=RingsProvider.generateData();
        Collections.shuffle(aRings);

        // Creating necklace objects
        aNecklaces = new ArrayList<Products>();
        aNecklaces=NecklacesProvider.generateData();
        Collections.shuffle(aNecklaces);

        // Creating earring objects
        aEarrings = new ArrayList<Products>();
        aEarrings=EarringsProvider.generateData();
        Collections.shuffle(aEarrings);


        // Assign titles to namesList as well as consolidating all products
        for(Products r: aRings){
            namesList.add(r.getName());
            allProducts.add(r);
        }
        for(Products e: aEarrings) {
            namesList.add(e.getName());
            allProducts.add(e);
        }
        for(Products n: aNecklaces) {
            namesList.add(n.getName());
            allProducts.add(n);
        }

        // Initialising the recyclerView for best-selling
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Collections.shuffle(allProducts);
        recycleAdapter = new RecycleAdapter(MainActivity.this, allProducts);

        // Setting the adapter for recyclerView
        recyclerView.setAdapter(recycleAdapter);
    }

    // When Rings category is clicked, this segment is executed
    public void showRingsActivity(View v) {
        Intent RingsIntent = new Intent(this, ListActivity.class);
        RingsIntent.putExtra("Objects", aRings);
        RingsIntent.putExtra("Title", "Rings");
        startActivity(RingsIntent);
    }

    // When Earrings category is clicked, this segment is executed
    public void showEarringsActivity(View v) {
        Intent EarringsIntent = new Intent (this, ListActivity.class);
        EarringsIntent.putExtra("Objects", aEarrings);
        EarringsIntent.putExtra("Title", "Earrings");
        startActivity(EarringsIntent);
    }

    // When Necklaces category is clicked, this segment is executed
    public void showNecklacesActivity(View v) {
        Intent NecklacesIntent= new Intent(this, ListActivity.class);
        NecklacesIntent.putExtra("Objects", aNecklaces);
        NecklacesIntent.putExtra("Title", "Necklaces");
        startActivity(NecklacesIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // We inflate the menu and add search items to the list
        getMenuInflater().inflate(R.menu.menu_search_list,menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();

        // Search only works after Enter has been pressed
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Reset SearchView
                //searchView.clearFocus();
                //searchView.setQuery("", false);
                //searchView.setIconified(true);
                //searchItem.collapseActionView();

                // Search function
                Intent searchIntent = new Intent(getApplicationContext(), SearchActivity.class);
                searchIntent.putExtra("Query", query);
                searchIntent.putExtra("AllObjects", allProducts);
                searchIntent.putExtra("namesList", namesList);
                startActivity(searchIntent);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }
}
