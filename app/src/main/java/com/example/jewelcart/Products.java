package com.example.jewelcart;

import java.io.Serializable;

// The 'serializable' interface is used to convert objects of the class into a byte-stream (so that
// the image addresses can be stored as well
public class Products implements Serializable {
    protected String itemID;

    // returns the byte values of the images stored in the res folder for the current itemID
    protected int[] itemImagePaths;
    protected String itemName;
    protected String itemMaterial;
    protected String itemPrice;
    protected String itemRating;


    public Products (String id, int[] imageAddress, String name, String material, String price, String rating) {
        this.itemID = id;
        this.itemImagePaths = imageAddress;
        this.itemName = name;
        this.itemMaterial = material;
        this.itemPrice = price;
        this.itemRating = rating;

    }

    public String getID() {
        return itemID;
    }

    public int[] getImageAddresses() {
        return itemImagePaths;
    }

    public String getName(){
        return itemName;
    }

    public String getMaterial() {
        return itemMaterial;
    }

    public String getPrice() {
        return itemPrice;
    }

    public String getRating() {
        return itemRating;
    }

}
