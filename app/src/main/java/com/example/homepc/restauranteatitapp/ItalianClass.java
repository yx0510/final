package com.example.homepc.restauranteatitapp;

/**
 * Created by HomePC on 1/9/2018.
 */

public class ItalianClass {
    private String Itemname;
    private String Itemprice;
    private int Itemimage;
    public int Itemquantity = 0;



    public ItalianClass(String iName, String iPrice, int iImage,int iquantity)
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

    void addquan()
    {
        Itemquantity = Itemquantity + 1;
        return ;
    }
}

