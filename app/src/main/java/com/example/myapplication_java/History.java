package com.example.myapplication_java;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class History extends AppCompatActivity {

    Button btnBackHistory;
    TextView tvPatientAge, tvPatientGender, tvPatientWeight, tvPatientHeight, tvPatientSmoker,
            tvPatientHeartDisease, tvPatientDiabetes, tvPatientHypertension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_history);

        tvPatientAge = findViewById(R.id.tvPatientAge);
        tvPatientGender = findViewById(R.id.tvPatientGender);
        tvPatientWeight = findViewById(R.id.tvPatientWeight);
        tvPatientHeight = findViewById(R.id.tvPatientHeight);
        tvPatientSmoker = findViewById(R.id.tvPatientSmoker);
        tvPatientHeartDisease = findViewById(R.id.tvPatientHeartDisease);
        tvPatientDiabetes = findViewById(R.id.tvPatientDiabetes);
        tvPatientHypertension = findViewById(R.id.tvPatientHypertension);

        loadPatientData();

        btnBackHistory = findViewById(R.id.btnHistoryBack);
        btnBackHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(History.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }

    private void loadPatientData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PatientDetails1.SHARED_PREFS, MODE_PRIVATE);

        String age = sharedPreferences.getString(PatientDetails1.AGE, "N/A");
        String gender = sharedPreferences.getString(PatientDetails1.GENDER, "N/A");
        String weight = sharedPreferences.getString(PatientDetails1.WEIGHT, "N/A");
        String height = sharedPreferences.getString(PatientDetails1.HEIGHT, "N/A");
        String smoker = sharedPreferences.getString(PatientDetails1.SMOKER, "N/A");
        boolean hasHeartDisease = sharedPreferences.getBoolean(PatientDetails1.HEART_DISEASE, false);
        boolean hasDiabetes = sharedPreferences.getBoolean(PatientDetails1.DIABETES, false);
        boolean hasHypertension = sharedPreferences.getBoolean(PatientDetails1.HYPERTENSION, false);

        tvPatientAge.setText("Age: " + age);
        tvPatientGender.setText("Gender: " + gender);
        tvPatientWeight.setText("Weight: " + weight);
        tvPatientHeight.setText("Height: " + height);
        tvPatientSmoker.setText("Smoker: " + smoker);
        tvPatientHeartDisease.setText("Heart Disease: " + (hasHeartDisease ? "Yes" : "No"));
        tvPatientDiabetes.setText("Diabetes: " + (hasDiabetes ? "Yes" : "No"));
        tvPatientHypertension.setText("Hypertension: " + (hasHypertension ? "Yes" : "No"));
    }
}
