package com.uts_kelompok12;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText Nomor1, Nomor2;
    private Button buttonTambah, buttonKurang, buttonKali, buttonBagi;
    private TextView textHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by their IDs
        Nomor1 = findViewById(R.id.Nomor1);
        Nomor2 = findViewById(R.id.Nomor2);
        buttonTambah = findViewById(R.id.buttonTambah);
        buttonKurang = findViewById(R.id.buttonKurang);
        buttonKali = findViewById(R.id.buttonKali);
        buttonBagi = findViewById(R.id.buttonBagi);
        textHasil = findViewById(R.id.textHasil);

        // Set click listeners for operator buttons
        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('+');
            }
        });

        buttonKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('-');
            }
        });

        buttonKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('*');
            }
        });

        buttonBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult('/');
            }
        });
    }

    private void calculateResult(char operator) {
        // Get input values from EditText fields
        int number1 = Integer.parseInt(Nomor1.getText().toString());
        int number2 = Integer.parseInt(Nomor2.getText().toString());

        int result = 0;
        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    textHasil.setText("Cannot divide by zero");
                    return;
                }
                break;
        }

        // Display the result
        textHasil.setText(String.valueOf(result));
    }
}
