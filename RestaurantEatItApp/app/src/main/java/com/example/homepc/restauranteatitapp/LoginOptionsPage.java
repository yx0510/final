package com.example.homepc.restauranteatitapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class LoginOptionsPage extends AppCompatActivity {
    Button sign_in,sign_up;
    DatabaseHelper myDB;
    LinearLayout l1,l2;
    Animation uptodown,downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options_page);
        sign_in = findViewById(R.id.signin);
        sign_up = findViewById(R.id.signup);

        l1 = findViewById(R.id.layout1);
        l2 = findViewById(R.id.layout2);

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);

        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);

        myDB = new DatabaseHelper(this);



        //開啟登入
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinpage = new Intent(LoginOptionsPage.this,SignInPage.class);
                startActivity(signinpage);
                finish();
            }
        });
        //開啟註冊
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signuppage = new Intent(LoginOptionsPage.this,SignUpPage.class);
                startActivity(signuppage);
                finish();

            }
        });


    }
}

