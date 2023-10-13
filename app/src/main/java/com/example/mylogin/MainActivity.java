package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    MaterialButton loginButton;
    MaterialButton SIGNUPButton; // Initialize this button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.LoginButton);
        SIGNUPButton = findViewById(R.id.SIGNUPButton); // Initialize SIGNUPButton

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = username.getText().toString();
                String enteredPassword = password.getText().toString();

                if (enteredUsername.equals("admin") && enteredPassword.equals("admin")) {
                    // Correct credentials
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                } else {
                    // Incorrect credentials
                    Toast.makeText(MainActivity.this, "LOGIN FAILED!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        SIGNUPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
