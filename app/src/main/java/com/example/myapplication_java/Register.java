package com.example.myapplication_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    Button btnRegComp;
    EditText inputName, inputEmail, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // make sure your XML file is named correctly

        inputName = findViewById(R.id.RegFullName);
        inputEmail = findViewById(R.id.RegEmail);
        inputPassword = findViewById(R.id.RegPassword);
        btnRegComp = findViewById(R.id.btnRegComp);

        btnRegComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStored = inputName.getText().toString().trim();
                String emailStored = inputEmail.getText().toString().trim();
                String passwordStored = inputPassword.getText().toString().trim();

                // Basic input validation
                if (nameStored.isEmpty() || emailStored.isEmpty() || passwordStored.isEmpty()) {
                    Toast.makeText(Register.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Insert new user into Supabase
                insertUserToSupabase(nameStored, emailStored, passwordStored);
            }
        });
    }

    private void insertUserToSupabase(String name, String email, String password) {
        SupabaseApi api = SupabaseClient.getClient().create(SupabaseApi.class);

        // Create a user object matching your Supabase table structure
        User newUser = new User();
        newUser.email = email;
        newUser.password = password;
        newUser.created_at = null; // Supabase will auto-fill timestamp
        newUser.id = null; // auto-generated UUID

        // Wrap single user in a list because Supabase expects an array for inserts
        List<User> userList = new ArrayList<>();
        userList.add(newUser);

        // Call the insert endpoint
        Call<List<User>> call = api.insertUsers(userList);

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Register.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                    // Go back to main activity or login screen
                    Intent intent = new Intent(Register.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Register.this, "Error: " + response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(Register.this, "Connection failed: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
