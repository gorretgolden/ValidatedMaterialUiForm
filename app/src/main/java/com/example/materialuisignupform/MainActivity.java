package com.example.materialuisignupform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    EditText username,email,pas1,pas2;
    Button button;
    String name,email_address,passward1,passward2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.login_button);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        pas1 = (EditText) findViewById(R.id.password1);
        pas2 = (EditText) findViewById(R.id.confirm_pasword);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //converting the user input into string
                email_address = email.getText().toString();
                name = username.getText().toString();
                passward1 = pas1.getText().toString();
                passward2 = pas2.getText().toString();


               //validations

                if (name.isEmpty()) {
                    username.setError("Please provide your username");
                }

                if (email_address.isEmpty()) {
                   email.setError("Please provide your email address");
                }


                if (passward1.isEmpty()) {
                    pas1.setError("Please enter your passward");
                }

                if (passward1.length()<8) {
                    pas1.setError("Your password is too short!");
                }

                if (passward2.isEmpty()) {
                    pas2.setError("Please confirm your passward");
                }

                if (passward2.equals(passward1)){
                    Toast.makeText(MainActivity.this, "You successfully created a new account!", Toast.LENGTH_SHORT).show();

                } else {

                    pas2.setError("Passwards don't match");

                }


            }
        });
    }
}