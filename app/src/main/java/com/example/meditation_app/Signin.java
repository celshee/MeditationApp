package com.example.meditation_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Signin extends AppCompatActivity {
    EditText editTextUsername, editTextPassword;
    Button buttonSignIn,buttonLogin;
    private com.example.meditation_app.DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonLogin = findViewById(R.id.buttonLogin);

        dbHelper = new com.example.meditation_app.DBHelper(this);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUserData();
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void insertUserData() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Check if username and password are not empty
        if (!username.isEmpty() && !password.isEmpty()) {
            boolean inserted = dbHelper.addUser(username, password);
            if (inserted) {
                Toast.makeText(this, "User data inserted successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failed to insert user data", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
        }
    }

}
