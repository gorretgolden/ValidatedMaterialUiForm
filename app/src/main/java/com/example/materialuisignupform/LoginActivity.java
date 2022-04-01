package com.example.materialuisignupform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    EditText email,password;
    Button buttonLogin;
    String email_address,passward1;
    TextView text_to_register;
    ImageView back;
    String user_password = "#golden@";
    String user_email = "nabatanzigorret143@gmail.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        buttonLogin = (Button) findViewById(R.id.login_button);
        email = (EditText) findViewById(R.id.loginemail);
        password = (EditText) findViewById(R.id.loginpasd);
        text_to_register = (TextView) findViewById(R.id.text_to_register);
        back = findViewById(R.id.back);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //converting the user input into string

                email_address = email.getText().toString();
                passward1 = password.getText().toString();


                //validations

                if (email_address.isEmpty()) {
                    email.setError("Please provide your email address ");
                }
                if (passward1.isEmpty()) {
                    password.setError("Please enter your passward");
                }


                if (!passward1.equals(user_password)) {

                    password.setError("Wrong passsword");


                }
                if(!email_address.equals(user_email)){
                    email.setError("Wrong email address");
                }
                if((passward1.equals(user_password)) && (email_address.equals(user_email)) ){
                    Toast.makeText(LoginActivity.this, "You successfully logged into your account!", Toast.LENGTH_SHORT).show();
                    Intent intentLogin = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intentLogin);

                }
                else {
                    Toast.makeText(LoginActivity.this, "All fields must be valid", Toast.LENGTH_SHORT).show();

                }


            }
        });

        text_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_register_page = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_register_page);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_register_page = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_register_page);

            }
        });
    }
}
