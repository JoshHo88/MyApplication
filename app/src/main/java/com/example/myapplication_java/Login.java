package com.example.myapplication_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    Button btnLogin_login;
    EditText inputName, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputName=findViewById(R.id.LoginName);
        inputPassword=findViewById(R.id.LoginPassword);

        btnLogin_login = findViewById(R.id.btnLogin_Login);
        btnLogin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameStored = inputName.getText().toString();
                String passwordStored = inputPassword.getText().toString();

                Intent intent = new Intent(Login.this,PatientDetails1.class);
                startActivity(intent);
            }
        });

    }
}