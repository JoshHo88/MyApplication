package com.example.myapplication_java;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PatientDetailsUpdate extends AppCompatActivity {

    Button btnUpdateDetails;
    EditText inputAge, inputGender, inputWeight, inputHeight, inputSmoker, inputFamilyHistory;

    // Define a new constant for the family history
    public static final String FAMILY_HISTORY = "family_history";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_details_update);

        // Use the correct IDs from the XML layout
        inputAge = findViewById(R.id.PatientAgeUpdate);
        inputGender = findViewById(R.id.PatientGenderUpdate);
        inputWeight = findViewById(R.id.patientWeightUpdate);
        inputHeight = findViewById(R.id.PatientHeightUpdate);
        inputSmoker = findViewById(R.id.PatientSmokerUpdate);
        inputFamilyHistory = findViewById(R.id.PatientFamilyHistoryUpdate);

        loadPatientData();

        btnUpdateDetails = findViewById(R.id.btnPatientDetailsNextUpdate); // Use the correct button ID
        btnUpdateDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInputs()) {
                    saveData();
                    Intent intent = new Intent(PatientDetailsUpdate.this, LastAssessment.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void loadPatientData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PatientDetails1.SHARED_PREFS, MODE_PRIVATE);

        inputAge.setText(sharedPreferences.getString(PatientDetails1.AGE, ""));
        inputGender.setText(sharedPreferences.getString(PatientDetails1.GENDER, ""));
        inputWeight.setText(sharedPreferences.getString(PatientDetails1.WEIGHT, ""));
        inputHeight.setText(sharedPreferences.getString(PatientDetails1.HEIGHT, ""));
        inputSmoker.setText(sharedPreferences.getString(PatientDetails1.SMOKER, ""));
        // Load family history instead of checkboxes
        inputFamilyHistory.setText(sharedPreferences.getString(FAMILY_HISTORY, ""));
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
            Toast.makeText(PatientDetailsUpdate.this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PatientDetails1.SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PatientDetails1.AGE, inputAge.getText().toString().trim());
        editor.putString(PatientDetails1.GENDER, inputGender.getText().toString().trim());
        editor.putString(PatientDetails1.WEIGHT, inputWeight.getText().toString().trim());
        editor.putString(PatientDetails1.HEIGHT, inputHeight.getText().toString().trim());
        editor.putString(PatientDetails1.SMOKER, inputSmoker.getText().toString().trim());
        // Save family history instead of checkboxes
        editor.putString(FAMILY_HISTORY, inputFamilyHistory.getText().toString().trim());

        // Remove the old checkbox data
        editor.remove(PatientDetails1.HEART_DISEASE);
        editor.remove(PatientDetails1.DIABETES);
        editor.remove(PatientDetails1.HYPERTENSION);

        editor.apply();
        Toast.makeText(this, "Data updated successfully", Toast.LENGTH_SHORT).show();
    }
}