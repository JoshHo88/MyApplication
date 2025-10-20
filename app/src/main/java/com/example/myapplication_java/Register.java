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

public class Register extends AppCompatActivity {

    Button btnRegComp;
    EditText inputName, inputEmail, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inputName=findViewById(R.id.RegFullName);
        inputEmail=findViewById(R.id.RegEmail);
        inputPassword=findViewById(R.id.RegPassword);

        btnRegComp = findViewById(R.id.btnRegComp);
        btnRegComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameStored = inputName.getText().toString();
                String emailStored = inputEmail.getText().toString();
                String passwordStored = inputPassword.getText().toString();

                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}