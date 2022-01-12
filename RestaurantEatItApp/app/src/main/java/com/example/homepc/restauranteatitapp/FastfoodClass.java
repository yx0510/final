package com.example.homepc.restauranteatitapp;

/**
 * Created by HomePC on 1/9/2018.
 */

public class FastfoodClass {


        private String Itemname;
        private String Itemprice;
        private int Itemimage;
        private int Itemquantity;

    public FastfoodClass(String iName, String iPrice, int iImage,int iquantity)
    {
        Itemname = iName;
        Itemprice = iPrice;
        Itemimage = iImage;
        Itemquantity = iquantity;



    }
    public String getItemName() {
        return Itemname;
    }

    public String getItemPrice() {return Itemprice;}

    public int getImageResourceId() {return Itemimage;}

    public int getItemquantity() {return Itemquantity;}


}


