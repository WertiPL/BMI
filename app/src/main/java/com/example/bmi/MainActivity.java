// Author s23141 Wiktor Rostkowski

package com.example.bmi;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();

    private double weight = 0.0;
    private double height = 0.15;
    private TextView heightTextView;
    private TextView weightTextView;
    private TextView sumBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightTextView = findViewById(R.id.heightView);
        weightTextView = findViewById(R.id.weightView);
        sumBMI = findViewById(R.id.outputBMI);
        sumBMI.setText(numberFormat.format(0));

        EditText heightEditView = findViewById(R.id.InputHeight);
        heightEditView.addTextChangedListener(HeightEditTextWatcher);

        EditText weightEditView = findViewById(R.id.InputWeight);
        weightEditView.addTextChangedListener(WeightEditTextWatcher);

        final Button buttonBMI = findViewById(R.id.bmibutton);
        buttonBMI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        if (height != 0) {
            double meterHeight = height /100;
            double bmi = weight / (meterHeight * meterHeight);
            sumBMI.setText(numberFormat.format(bmi));
        } else {
            sumBMI.setText(numberFormat.format(0));
        }
    }

    private final TextWatcher HeightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                height = Double.parseDouble(s.toString());
                heightTextView.setText(numberFormat.format(height));
            } catch (NumberFormatException e) {
                heightTextView.setText("");
                sumBMI.setText("Invalid input for height");
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };

    private final TextWatcher WeightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                weight = Double.parseDouble(s.toString());
                weightTextView.setText(numberFormat.format(weight));
            } catch (NumberFormatException e) {
                weightTextView.setText("");
                sumBMI.setText("Invalid input for weight");
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };

}
