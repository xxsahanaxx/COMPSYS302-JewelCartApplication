package com.example.jewelcart;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView lvProducts;
    ListAdapter prodAdapter;
    String title;
    ArrayList<Products> aProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lvProducts = (ListView) findViewById(R.id.lvProducts);

        aProducts = (ArrayList<Products>) getIntent().getSerializableExtra("Objects");
        prodAdapter = new ListAdapter(this, aProducts);

        title = new String();
        title = getIntent().getStringExtra("Title");
        ListActivity.this.setTitle(title);

        lvProducts.setAdapter(prodAdapter);

        LinearLayoutManager lm = new LinearLayoutManager(this);

        setupOnSelectedListener();
    }

    //go to the details page
    public void setupOnSelectedListener() {
        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("Object", prodAdapter.getItem(position));
                startActivity(intent);
            }
        });
    }
}
