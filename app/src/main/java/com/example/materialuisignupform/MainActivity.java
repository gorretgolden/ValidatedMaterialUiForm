package com.example.materialuisignupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    EditText username,email,pas1,pas2,phone_number;
    Button button;
    String name,email_address,phone,passward1,passward2;
    Intent Login, Register;
    TextView text_to_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.signup_button);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        phone_number = (EditText) findViewById(R.id.phone_number);
        pas1 = (EditText) findViewById(R.id.password1);
        pas2 = (EditText) findViewById(R.id.confirm_pasword);
        text_to_login = findViewById(R.id.text_to_togin);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //converting the user input into string
                email_address = email.getText().toString();
                phone = phone_number.getText().toString();
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
                if (phone.isEmpty()) {
                    phone_number.setError("Please provide your contact number");
                }

                if (passward1.isEmpty()) {
                    pas1.setError("Please enter your passward");
                }

                if (passward1.length()<8) {
                    pas1.setError("Your password is too short!");
                }

                if (passward2.isEmpty()) {
                    pas2.setError("Please confirm your password");
                }

                if (!passward2.equals(passward1)){
                    pas2.setError("Passwords don't match");
//

                }
                if(!email_address.isEmpty() && !name.isEmpty() && !passward1.isEmpty() && passward2.equals(passward1) && passward1.length()>=8 && !phone.isEmpty()){
                    Toast.makeText(MainActivity.this, "You successfully created a new account!", Toast.LENGTH_SHORT).show();
                    Login = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(Login);
                }
                else {

                    Toast.makeText(MainActivity.this, "All fields must be valid ", Toast.LENGTH_SHORT).show();


                }

            }

        });
        text_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(Register);

            }
        });
    }
}