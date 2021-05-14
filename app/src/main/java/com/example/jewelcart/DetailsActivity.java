package com.example.jewelcart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class DetailsActivity extends AppCompatActivity {
    private TextView ProductName, ProductID, ProductPrice, ProductMaterial, ProductRating;
    CarouselView carouselView;
    int Number_of_pages=3;

    Products curProd = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Code is from https://github.com/sayyam/carouselview
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(Number_of_pages);

        ProductPrice = (TextView) findViewById(R.id.ProductPrice);
        ProductName = (TextView) findViewById(R.id.ProductName);
        ProductMaterial =(TextView) findViewById(R.id.ProductMaterial);
        ProductRating = (TextView) findViewById(R.id.ProductRating);
        ProductID = (TextView) findViewById(R.id.ProductID);

        curProd = (Products) getIntent().getSerializableExtra("Object");


        carouselView.setImageListener(imageListener);
        loadProduct();
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {

            int[] resID = curProd.getImageAddresses();
            imageView.setImageResource(resID[position]);
        }
    };


    private void loadProduct() {

        this.setTitle(curProd.getName());

        ProductName.setText(curProd.getName());
        ProductPrice.setText(curProd.getPrice());
        ProductMaterial.setText((curProd.getMaterial()));
        ProductRating.setText(curProd.getRating());
        ProductID.setText(curProd.getID());

    }

}

