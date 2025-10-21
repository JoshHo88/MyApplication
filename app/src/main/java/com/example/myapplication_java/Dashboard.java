package com.example.myapplication_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dashboard extends AppCompatActivity{

    Button btnHealthSummary, btnVitalSigns, btnLastAssessment, btnViewHistory, btnAskAI;
    TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        btnHealthSummary = findViewById(R.id.btnHealth);
        btnVitalSigns = findViewById(R.id.btnVital);
        btnLastAssessment = findViewById(R.id.btnAssessment);
        btnViewHistory = findViewById(R.id.btnHistory);
        btnAskAI = findViewById(R.id.btnAI);

//needs to take patients details
        btnHealthSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Result.class);
                startActivity(intent);
            }
        });

        btnVitalSigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, PatientsVitalSigns.class);
                startActivity(intent);
            }
        });

        btnLastAssessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, LastAssessment.class);
                startActivity(intent);
            }
        });

        btnAskAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, AIresult.class);
                startActivity(intent);
            }
        });

        btnViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, PatientsActivity.class);
                startActivity(intent);
            }
        });

    }

}
