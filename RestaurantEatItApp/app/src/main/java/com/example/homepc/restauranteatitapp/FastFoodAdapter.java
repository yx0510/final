package com.example.homepc.restauranteatitapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HomePC on 1/9/2018.
 */

public class FastFoodAdapter extends ArrayAdapter<FastfoodClass> {
    int quantity = 0;
    int i = 0;
    int pos = 0, counter = 1;
    String [] order_details = new String[1000];
    DatabaseHelper mydb;

    public FastFoodAdapter(Activity context, ArrayList<FastfoodClass> fastfood) {
        super(context, 0, fastfood);
        this.mydb = new DatabaseHelper(context.getApplicationContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.menu_design, parent, false);
        }

        FastfoodClass currentfastfood = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.item_image);
        imageView.setImageResource(currentfastfood.getImageResourceId());

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.item_name);
        nameTextView.setText(currentfastfood.getItemName());

        TextView priceTextView = (TextView) listItemView.findViewById(R.id.item_price);
        priceTextView.setText("Price " + currentfastfood.getItemPrice());

        Button plus = (Button) listItemView.findViewById(R.id.plus_btn);
        final View finalListItemView1 = listItemView;
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView quantityTextView = (TextView) finalListItemView1.findViewById(R.id.quantity);
                int qi = Integer.parseInt((String) quantityTextView.getText());
                quantity = qi + 1;
                quantityTextView.setText(String.valueOf(quantity));
            }
        });

        Button minus = (Button) listItemView.findViewById(R.id.minus_btn);
        final View finalListItemView = listItemView;
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView quantityTextView = (TextView) finalListItemView.findViewById(R.id.quantity);
                int qq = Integer.parseInt((String) quantityTextView.getText());
                if (qq > 0) quantity = qq - 1;
                else quantity = 0;
                quantityTextView.setText(String.valueOf(quantity));
            }
        });

        Button cart_btn = (Button) listItemView.findViewById(R.id.cart_btn);
        cart_btn.setTag(position);

        cart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = (Integer)view.getTag();
                if(quantity != 0) {
                    if (pos == 0) {
                        boolean isinserted = mydb.Add_to_Cart("Beef Burger",String.valueOf(quantity),String.valueOf(300*quantity));
                        if (isinserted)
                        {
                            order_details[i] = "Id " + counter + " Beef Burger Price NT " + 300 * quantity;
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Successfully !", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getContext(), "Try again", Toast.LENGTH_SHORT).show();
                    }
                    if (pos == 1) {
                        boolean isinserted =  mydb.Add_to_Cart("Chicken Burger",String.valueOf(quantity),String.valueOf(350*quantity));
                        if (isinserted)
                        {
                            order_details[i] = "Id " + counter + " Chicken Burger Price NT " + 350 * quantity;
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Successfully !", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getContext(), "Try again", Toast.LENGTH_SHORT).show();
                    }
                    if (pos == 2) {
                        boolean isinserted = mydb.Add_to_Cart("Zinger Burger",String.valueOf(quantity),String.valueOf(660*quantity));
                        if (isinserted)
                        {
                            order_details[i] = "Id : " + counter + " Zinger Burger Price NT " + 660 * quantity;
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Successfully !", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getContext(), "Please, Try again", Toast.LENGTH_SHORT).show();
                    }
                    if (pos == 3) {
                        boolean isinserted = mydb.Add_to_Cart("Chicken Nuggets",String.valueOf(quantity),String.valueOf(985*quantity));
                        if (isinserted)
                        {
                            order_details[i] = "Id " + counter + " Chicken Nuggets Price NT " + 985 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Successfully !", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getContext(), "Try again", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getContext(), "數量不能為0", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return listItemView;
    }
}