package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class security_login extends AppCompatActivity {

    private EditText login_username;
    private EditText login_password;
    private Button loginButton;

    private final String validUsername = "Guard";
    private final String validPassword = "123";
    private Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_login);

        login_username = findViewById(R.id.login_username);
        login_password = findViewById(R.id.login_password);
        login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredUsername = login_username.getText().toString();
                String enteredPassword = login_password.getText().toString();

                if (enteredUsername.equals(validUsername) && enteredPassword.equals(validPassword)) {
                    // Successful login
                    Intent intent = new Intent(security_login.this,QR.class);
                    startActivity(intent);

                } else {
                    // Invalid login
                    Toast.makeText(security_login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}