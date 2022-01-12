package com.example.homepc.restauranteatitapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HomePC on 1/9/2018.
 */

public class ItalianAdapter extends ArrayAdapter<ItalianClass> {
    int quantity = 0; int i = 0;
    int pos = 0, counter = 1;
    String [] order_details = new String[1000];
    DatabaseHelper mydb;


    public ItalianAdapter(Activity context, ArrayList<ItalianClass> i_food) {
        super(context, 0, i_food);
        this.mydb = new DatabaseHelper(context.getApplicationContext());

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.menu_design, parent, false);
        }

        final ItalianClass currenti_food = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.item_image);
        imageView.setImageResource(currenti_food.getImageResourceId());

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.item_name);
        nameTextView.setText(currenti_food.getItemName());

        TextView priceTextView = (TextView) listItemView.findViewById(R.id.item_price);
        priceTextView.setText("Price " + currenti_food.getItemPrice() );



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
                        boolean isinserted = mydb.Add_to_Cart("Pasta",String.valueOf(quantity),String.valueOf(450*quantity));
                        if (isinserted)
                        {
                            order_details[i] = "Id " + counter + " Pasta Price Rs " + 450 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Successfully !", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getContext(), "Try again", Toast.LENGTH_SHORT).show();
                    }

                    if (pos == 1) {
                        boolean isinserted =  mydb.Add_to_Cart("Lasagna",String.valueOf(quantity),String.valueOf(650*quantity));
                        if (isinserted)
                        {
                            order_details[i] = "Id " + counter + " Lasagna Price Rs " + 650 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Successfully !", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getContext(), "Try again", Toast.LENGTH_SHORT).show();
                    }

                    if (pos == 2) {
                        boolean isinserted = mydb.Add_to_Cart("Italian Pizza",String.valueOf(quantity),String.valueOf(1250*quantity));
                        if (isinserted)
                        {
                            order_details[i] = "Id : " + counter + " Italian Pizza Price Rs " + 1250 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Successfully !", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "Try again", Toast.LENGTH_SHORT).show();
                    }

                    if (pos == 3) {
                        boolean isinserted = mydb.Add_to_Cart("Focaccia Bread",String.valueOf(quantity),String.valueOf(450*quantity));
                        if (isinserted)
                        {
                            order_details[i] = "Id " + counter + " Focaccia Bread Price Rs " + 450 * quantity + " ";
                            counter++;
                            i++;
                            quantity = 0;
                            Toast.makeText(getContext(), "Successfully !", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getContext(), "Try again", Toast.LENGTH_SHORT).show();
                    }

                    else {

                        Toast.makeText(getContext(), "數量不能為0", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        return listItemView;
    }
}
