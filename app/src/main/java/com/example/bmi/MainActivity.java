package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText weightInput, heightFtInput, heightInInput;
    Button calculateButton, clearButton;
    TextView resultText;
    LinearLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Link XML

        // Hook UI components
        weightInput = findViewById(R.id.Weight);
        heightFtInput = findViewById(R.id.HeightFt);
        heightInInput = findViewById(R.id.HeightIn);
        calculateButton = findViewById(R.id.Buttonbmi);
        clearButton = findViewById(R.id.ButtonClear);
        resultText = findViewById(R.id.Result);
        rootLayout = findViewById(R.id.rootLayout);

        // When calculate is clicked
        calculateButton.setOnClickListener(v -> {
            String w = weightInput.getText().toString().trim();
            String ft = heightFtInput.getText().toString().trim();
            String inch = heightInInput.getText().toString().trim();

            if (w.isEmpty() || ft.isEmpty() || inch.isEmpty()) {
                Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int weight = Integer.parseInt(w);
                int feet = Integer.parseInt(ft);
                int inches = Integer.parseInt(inch);

                int totalInches = (feet * 12) + inches;
                double heightMeters = totalInches * 0.0254;
                double bmi = weight / (heightMeters * heightMeters);

                String status;
                int color;

                if (bmi > 25) {
                    status = "You are Overweight.\nFocus on fitness!";
                    color = getColor(android.R.color.holo_red_light);
                } else if (bmi < 18.5) {
                    status = "You are Underweight.\nEat more nutritious food!";
                    color = getColor(android.R.color.holo_orange_light);
                } else {
                    status = "You're Healthy!\nKeep it up!";
                    color = getColor(android.R.color.holo_green_light);
                }

                resultText.setText(String.format("Your BMI is: %.2f\n%s", bmi, status));
                rootLayout.setBackgroundColor(color);

            } catch (Exception e) {
                Toast.makeText(this, "Invalid input format", Toast.LENGTH_SHORT).show();
            }
        });

        // Clear inputs
        clearButton.setOnClickListener(v -> {
            weightInput.setText("");
            heightFtInput.setText("");
            heightInInput.setText("");
            resultText.setText("Your BMI result will appear here.");
            rootLayout.setBackgroundColor(getColor(android.R.color.background_light));
        });
    }
}
