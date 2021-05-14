package com.example.jewelcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    ListView searchResultslist;
    ArrayAdapter<String> searchAdapter;
    ListAdapter objectAdapter;

    String query;

    ArrayList<String> listofNames;
    ArrayList<Products> allProducts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchResultslist = findViewById(R.id.list_view);

        listofNames = getIntent().getStringArrayListExtra("namesList");

        allProducts = (ArrayList<Products>) getIntent().getSerializableExtra("AllObjects");

        query = getIntent().getStringExtra("Query");


        // Initialise searchAdapter to hold these values
        searchAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listofNames);

        // Set Adapter to list view
        searchResultslist.setAdapter(searchAdapter);


        searchAdapter.getFilter().filter(query, new Filter.FilterListener() {
            public void onFilterComplete(int count) {
                if (count == 0){
                    Toast.makeText(getApplicationContext(), "Product not found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set activity title to search query
        SearchActivity.this.setTitle(query);

        // When the particular item is clicked on the menu
        searchResultslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for(Products p: allProducts) {
                    if(p.getName().matches(searchAdapter.getItem(i))){
                        Intent intent = new Intent (getApplicationContext(), DetailsActivity.class);
                        intent.putExtra("Object", p);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}

