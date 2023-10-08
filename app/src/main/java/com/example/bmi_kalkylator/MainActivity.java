package com.example.bmi_kalkylator;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

        public class MainActivity extends AppCompatActivity {

            EditText weightInput, heightInput;
            Button calculateButton;
            TextView resultofBMI;
            TextView wrongInput;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                weightInput = findViewById(R.id.weightInput);
                heightInput = findViewById(R.id.lengthInput);
                calculateButton = findViewById(R.id.BMIButton);
                resultofBMI = findViewById(R.id.resultOfBMI);
                wrongInput = findViewById(R.id.wrongInput);

                calculateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        calculateBMI();
                    }
                });
            }

            private void calculateBMI() {
                String weightText = weightInput.getText().toString();
                String heightText = heightInput.getText().toString();

                if (!weightText.isEmpty() && !heightText.isEmpty()) {
                    double weight = Double.parseDouble(weightText);
                    double height = Double.parseDouble(heightText);

                    if (height > 0) {
                        double bmi = weight / (height * height);
                        //Gör om utskriften till endast 2 decimaler
                        resultofBMI.setText("Din BMI är: " +String.format ("%.2f", bmi));
                        wrongInput.setText("");
                    } else {
                        resultofBMI.setText("");
                        wrongInput.setText(R.string.fel_input);
                    }
                } else {
                    resultofBMI.setText("");
                    wrongInput.setText(R.string.fel_input);
                }
            }
        }


