package com.example.myapplication_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PatientsActivity extends AppCompatActivity {

    Button btnPatientActivityNext;
    EditText inputActivity, inputDuration, inputCalories, inputDate, inputFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_activity);

        inputActivity=findViewById(R.id.patientActivityType);
        inputDuration=findViewById(R.id.patientDuration);
        inputCalories=findViewById(R.id.patientCalories);
        inputDate=findViewById(R.id.patientDate);
        inputFood=findViewById(R.id.patientFood);

        btnPatientActivityNext=findViewById(R.id.btnPatientActivityNext);
        btnPatientActivityNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String TypeActivityStored = inputActivity.getText().toString();
                String Duration = inputDuration.getText().toString();
                String Calories = inputCalories.getText().toString();
                String Date = inputDate.getText().toString();
                String Food = inputFood.getText().toString();

                Intent intent = new Intent(PatientsActivity.this,PatientsVitalSigns.class);
                startActivity(intent);
            }
        });

    }
}