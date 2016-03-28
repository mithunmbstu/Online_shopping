package com.example.user.onlineshopping.Activity.Iteamrow;

/**
 * Created by User on 3/9/2016.
 */
public class Listrowiteam {



    String image;
    String name;
    String description;
    String price;

    public Listrowiteam(String image, String name, String description, String price) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Listrowiteam() {
        super();

    }


    public void setName(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

