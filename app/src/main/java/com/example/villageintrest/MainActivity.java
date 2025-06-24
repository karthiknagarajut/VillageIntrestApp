package com.example.villageintrest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etAmount, etRate, etYears, etMonths, etDays;
    private Button btnCalculate, btnReset;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmount = findViewById(R.id.etAmount);
        etRate = findViewById(R.id.etRate);
        etYears = findViewById(R.id.etYears);
        etMonths = findViewById(R.id.etMonths);
        etDays = findViewById(R.id.etDays);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnReset = findViewById(R.id.btnReset);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(v -> calculateInterest());
        btnReset.setOnClickListener(v -> resetFields());
    }

    private void calculateInterest() {
        // Validate input fields
        if (etAmount.getText().toString().isEmpty() ||
                etRate.getText().toString().isEmpty() ||
                etYears.getText().toString().isEmpty() ||
                etMonths.getText().toString().isEmpty() ||
                etDays.getText().toString().isEmpty()) {

            // Show a toast message if any input is missing
            Toast.makeText(MainActivity.this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return;
        }

        // Parse values
        double amount = Double.parseDouble(etAmount.getText().toString());
        double rate = Double.parseDouble(etRate.getText().toString());
        double years = Double.parseDouble(etYears.getText().toString());
        double months = Double.parseDouble(etMonths.getText().toString());
        double days = Double.parseDouble(etDays.getText().toString());

        // Calculate interest
        double interest = ((amount * rate * years * 12) / 100) +
                ((amount * rate * months) / 100) +
                ((amount * rate * days) / 3000);
        double totalAmount = amount + interest;

        // Display the result
        String result = "Interest: " + String.format(Locale.US, "%.2f", interest) + "\n" +
                "Total Amount: " + String.format(Locale.US, "%.2f", totalAmount);
        tvResult.setText(result);
    }

    private void resetFields() {
        // Reset all input fields and result
        etAmount.setText("");
        etRate.setText("");
        etYears.setText("");
        etMonths.setText("");
        etDays.setText("");
        tvResult.setText("Result will be displayed here");
    }
}
