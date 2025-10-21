package com.example.myapplication_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class Dashboard extends AppCompatActivity{

    MaterialCardView btnHealthSummary, btnVitalSigns, btnLastAssessment, btnViewHistory, btnAskAI, btnAiActivity;
    ImageButton btnProfile;
    Button btnLogut;
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
        btnAiActivity = findViewById(R.id.btnAiActivity);
        btnProfile = findViewById(R.id.btnProfileDash);
        btnLogut = findViewById(R.id.btnLogoutDash);

        btnHealthSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, PatientDetailsUpdate.class);
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
                Intent intent = new Intent(Dashboard.this, ChatBot.class);
                startActivity(intent);
            }
        });

        btnAiActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, PatientsActivity.class);
                startActivity(intent);
            }
        });

        btnViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, History.class);
                startActivity(intent);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Profile.class);
                startActivity(intent);
            }
        });

        btnLogut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
