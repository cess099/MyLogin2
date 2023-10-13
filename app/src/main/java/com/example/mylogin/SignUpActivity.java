package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText email;
    EditText password;
    EditText confirmPassword;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        firstName = findViewById(R.id.firstname);
        lastName = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        signUpButton = findViewById(R.id.SIGNUPButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredFirstName = firstName.getText().toString();
                String enteredLastName = lastName.getText().toString();
                String enteredEmail = email.getText().toString();
                String enteredPassword = password.getText().toString();
                String enteredConfirmPassword = confirmPassword.getText().toString();

                // Perform sign-up validation and logic here
                if (enteredPassword.equals(enteredConfirmPassword)) {
                    // Passwords match, perform sign-up logic
                    Toast.makeText(SignUpActivity.this, "SIGN UP SUCCESSFUL", Toast.LENGTH_SHORT).show();
                } else {
                    // Passwords do not match, show an error message
                    Toast.makeText(SignUpActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // You can add an intent to navigate to another activity here
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });
    }

    private class NextActivity {
    }
}
