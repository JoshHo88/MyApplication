package com.example.myapplication_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PatientDetails1 extends AppCompatActivity {

    Button btnPatientDetailsNext;
    EditText inputAge, inputGender, inputWeight, inputHeight, inputSmoker;
    CheckBox chHeartDisease, chDiabetes, chHypertention;
    Boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details1);

        inputAge=findViewById(R.id.PatientAge);
        inputGender=findViewById(R.id.PatientGender);
        inputWeight=findViewById(R.id.patientWeight);
        inputHeight=findViewById(R.id.PatientSmoker);

        btnPatientDetailsNext = findViewById(R.id.btnPatientDetailsNext);

        chHeartDisease = findViewById(R.id.checkBoxHeartDisease);
        chDiabetes = findViewById(R.id.checkBoxDiabetes);
        chHypertention = findViewById(R.id.checkBoxHypertention);

        chHeartDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chHeartDisease.isChecked()){
                    String HeartDisease = "Yes";
                }
            }
        });

        chDiabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Diabetes = "Yes";
            }
        });

        chHypertention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Hypertention = "yes";
            }
        });

        btnPatientDetailsNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ageStored = inputAge.getText().toString();
                String genderStored = inputGender.getText().toString();
                String weightStored = inputWeight.getText().toString();
                String heightStored = inputHeight.getText().toString();

                Intent intent = new Intent(PatientDetails1.this, PatientsActivity.class);
                startActivity(intent);
            }
        });



    }
}