package com.example.myapplication_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PatientsActivity extends AppCompatActivity {

    Button btnPatientActivityNext, btnCheckActivity;
    EditText inputActivity, inputDuration, inputCalories, inputDate, inputFood;
    TextView aiResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_activity);

        // Patient input fields
        inputActivity = findViewById(R.id.patientActivityType);
        inputDuration = findViewById(R.id.patientDuration);
        inputCalories = findViewById(R.id.patientCalories);
        inputDate = findViewById(R.id.patientDate);
        inputFood = findViewById(R.id.patientFood);

        // Next button (existing navigation)
        btnPatientActivityNext = findViewById(R.id.btnPatientActivityNext);
        btnPatientActivityNext.setOnClickListener(view -> {
            Intent intent = new Intent(PatientsActivity.this, PatientsVitalSigns.class);
            startActivity(intent);
        });

        // --- AI Activity Check section ---
        btnCheckActivity = findViewById(R.id.btnCheckActivity);
        aiResponse = findViewById(R.id.aiResponse);

        btnCheckActivity.setOnClickListener(v -> {
            String activity = inputActivity.getText().toString().trim();
            String duration = inputDuration.getText().toString().trim();
            String calories = inputCalories.getText().toString().trim();
            String date = inputDate.getText().toString().trim();
            String food = inputFood.getText().toString().trim();

            if (activity.isEmpty() || duration.isEmpty() || calories.isEmpty() || date.isEmpty()) {
                Toast.makeText(PatientsActivity.this, "Please fill in all fields before checking.", Toast.LENGTH_SHORT).show();
                return;
            }

            aiResponse.setText("Analyzing activity...");

            // Build a smart prompt for the AI
            String prompt = "Analyze this patient’s activity:\n" +
                    "Activity: " + activity + "\n" +
                    "Duration: " + duration + " minutes\n" +
                    "Calories burned: " + calories + "\n" +
                    "Date: " + date + "\n" +
                    "Food intake: " + food + "\n\n" +
                    "Tell me if this is a good activity for the patient and suggest improvements.";

            // Run AI call on a background thread
            new Thread(() -> {
                String answer = AIHelper.askAI(prompt);
                runOnUiThread(() -> aiResponse.setText(answer));
            }).start();
        });
    }
}
