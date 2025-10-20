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

public class PatientsVitalSigns extends AppCompatActivity {

    Button btnVitalNext;
    EditText inputHeartRate, inputBloodPressure, inputCholesterol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_vital_signs);

        inputHeartRate=findViewById(R.id.patientHeartRate);
        inputBloodPressure=findViewById(R.id.patientBloodPressure);
        inputCholesterol=findViewById(R.id.patientCholesterol);

        btnVitalNext=findViewById(R.id.btnVitalSignsNext);
        btnVitalNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String heartRateStored = inputHeartRate.getText().toString();
                String bloodPressureStored = inputBloodPressure.getText().toString();
                String CholesterolStored = inputCholesterol.getText().toString();

                Intent intent = new Intent(PatientsVitalSigns.this, Result.class);
                startActivity(intent);
            }
        });
    }
}