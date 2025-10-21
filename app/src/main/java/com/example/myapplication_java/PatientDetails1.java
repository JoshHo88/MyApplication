package com.example.myapplication_java;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PatientDetails1 extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String AGE = "age";
    public static final String GENDER = "gender";
    public static final String WEIGHT = "weight";
    public static final String HEIGHT = "height";
    public static final String SMOKER = "smoker";
    public static final String HEART_DISEASE = "heart_disease";
    public static final String DIABETES = "diabetes";
    public static final String HYPERTENSION = "hypertension";

    Button btnPatientDetailsNext;
    EditText inputAge, inputGender, inputWeight, inputHeight, inputSmoker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details1);

        inputAge = findViewById(R.id.PatientAge);
        inputGender = findViewById(R.id.PatientGender);
        inputWeight = findViewById(R.id.patientWeight);
        inputHeight = findViewById(R.id.PatientHeight);
        inputSmoker = findViewById(R.id.PatientSmoker);

        btnPatientDetailsNext = findViewById(R.id.btnPatientDetailsNext);


        btnPatientDetailsNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInputs()) {
                    saveData();
                    Intent intent = new Intent(PatientDetails1.this, Dashboard.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateInputs() {
        String ageStored = inputAge.getText().toString().trim();
        String genderStored = inputGender.getText().toString().trim();
        String weightStored = inputWeight.getText().toString().trim();
        String heightStored = inputHeight.getText().toString().trim();
        String smokerStored = inputSmoker.getText().toString().trim();

        boolean hasError = false;
        if (ageStored.isEmpty()) {
            inputAge.setError("This field is required");
            hasError = true;
        }
        if (genderStored.isEmpty()) {
            inputGender.setError("This field is required");
            hasError = true;
        }
        if (weightStored.isEmpty()) {
            inputWeight.setError("This field is required");
            hasError = true;
        }
        if (heightStored.isEmpty()) {
            inputHeight.setError("This field is required");
            hasError = true;
        }
        if (smokerStored.isEmpty()) {
            inputSmoker.setError("This field is required");
            hasError = true;
        }

        if (hasError) {
            Toast.makeText(PatientDetails1.this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(AGE, inputAge.getText().toString().trim());
        editor.putString(GENDER, inputGender.getText().toString().trim());
        editor.putString(WEIGHT, inputWeight.getText().toString().trim());
        editor.putString(HEIGHT, inputHeight.getText().toString().trim());
        editor.putString(SMOKER, inputSmoker.getText().toString().trim());

        editor.apply();
        Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();
    }
}