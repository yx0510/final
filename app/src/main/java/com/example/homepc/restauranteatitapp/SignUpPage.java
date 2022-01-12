package com.example.homepc.restauranteatitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText signupName, signupPassword;
    Button addAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        myDB = new DatabaseHelper(this);
        signupName = findViewById(R.id.signup_id);
        signupPassword = findViewById(R.id.signup_password);
        addAccount = findViewById(R.id.add_account);
        Add_User();
    }

    public void Add_User() {
        addAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((signupName.getText().toString().equals("")) && (signupPassword.getText().toString().equals("")))
                {
                    Toast.makeText(SignUpPage.this, "帳密不能為空", Toast.LENGTH_SHORT).show();
                }
                else if ((signupName.getText().toString().equals("")))
                {
                    Toast.makeText(SignUpPage.this, "Username不能為空", Toast.LENGTH_SHORT).show();
                }
                else if(signupPassword.getText().toString().equals(""))
                {
                    Toast.makeText(SignUpPage.this, "Password不能為空", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    boolean isinserted = myDB.Add_Account(signupName.getText().toString(), signupPassword.getText().toString());
                    if (isinserted)
                    {
                        Toast.makeText(SignUpPage.this, "Successfully !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),SignInPage.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                        Toast.makeText(SignUpPage.this, "Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
