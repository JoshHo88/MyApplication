package com.example.myapplication_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    Button btnLogin_login;
    EditText inputName, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputName = findViewById(R.id.LoginName);
        inputPassword = findViewById(R.id.LoginPassword);
        btnLogin_login = findViewById(R.id.btnLogin_Login);

        btnLogin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStored = inputName.getText().toString().trim();
                String passwordStored = inputPassword.getText().toString().trim();

                if (nameStored.isEmpty() || passwordStored.isEmpty()) {
                    Toast.makeText(Login.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check user from Supabase
                verifyUser(nameStored, passwordStored);
            }
        });
    }

    private void verifyUser(String name, String enteredPassword) {
        SupabaseApi api = SupabaseClient.getClient().create(SupabaseApi.class);

        // Pull all users (same way you did in Register.java — no new method)
        Call<List<User>> call = api.getUsers("*");

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<User> users = response.body();
                    boolean found = false;

                    for (User u : users) {
                        if (u.email != null && u.email.equalsIgnoreCase(name)) {
                            found = true;
                            // Compare entered password with hashed password from DB
                            boolean ok = PasswordHasher.verifyPassword(enteredPassword, u.password);

                            if (ok) {
                                Toast.makeText(Login.this, "Login successful!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login.this, PatientDetails1.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Login.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        }
                    }

                    if (!found) {
                        Toast.makeText(Login.this, "User not found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Login.this, "Error: " + response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(Login.this, "Connection failed: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
