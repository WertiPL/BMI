package com.example.bmi;

import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private static final NumberFormat numberFormat =
            NumberFormat.getNumberInstance();

    private double weight = 0.0;
    private double height = 0.15;
    private TextView heightTextView;
    private TextView weightTextView;
    private TextView sumBMI;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        // get references to programmatically manipulated TextViews
        heightTextView = (TextView) findViewById(R.id.InputHeight);
        weightTextView = (TextView) findViewById(R.id.InputWeight);
        sumBMI = (TextView) findViewById(R.id.outputBMI);
        sumBMI.setText(numberFormat.format(0));

        final Button buttonBMI = findViewById(R.id.bmibutton);
        buttonBMI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculate();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // calculate and display BMI
    private void calculate() {


        double bmi = weight / height;

        sumBMI.setText(numberFormat.format(bmi));
    }

    private final TextWatcher EditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {

                weight = Double.parseDouble(s.toString());
                height = Double.parseDouble(s.toString());
                if(weight >= 0 && height >0 )
                {

                    heightTextView.setText(numberFormat.format(height));

                }}
            catch (NumberFormatException e) { // if s is empty or non-numeric
                weightTextView.setText("");
                heightTextView.setText("");
                sumBMI.setText(numberFormat.format("0")); ;
            }

            calculate();
        }


        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };






}