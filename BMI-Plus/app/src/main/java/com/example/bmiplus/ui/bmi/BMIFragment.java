package com.example.bmiplus.ui.bmi;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bmiplus.databinding.FragmentBmiBinding;
import com.example.bmiplus.ui.Calories.CaloriesViewModel;

import java.text.NumberFormat;

public class BMIFragment extends Fragment {

    private FragmentBmiBinding binding;
    private BMIViewModel bmiViewModel;
    private double weight = 0.0;
    private double height = 0.15;
    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        BMIViewModel bmiViewModel =
                new ViewModelProvider(this).get(BMIViewModel.class);

        binding = com.example.bmiplus.databinding.FragmentBmiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        EditText heightEditView = binding.InputHeight;
        EditText weightEditView = binding.InputWeight;

        heightEditView.addTextChangedListener(HeightEditTextWatcher);
        weightEditView.addTextChangedListener(WeightEditTextWatcher);

        Button buttonBMI = binding.bmibutton;
        final TextView textViewBMi = binding.textBMI;

        buttonBMI.setOnClickListener(v -> calculate());

        bmiViewModel.getText().observe(getViewLifecycleOwner(), textViewBMi::setText);
        return root;
    }

    private final TextWatcher HeightEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                height = Double.parseDouble(s.toString());
            } catch (NumberFormatException e) {
                height=0;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }

    };

    private final TextWatcher WeightEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                weight = Double.parseDouble(s.toString());

            } catch (NumberFormatException e) {
                weight = 0;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }

        // Implement other TextWatcher methods
    };

    private void calculate() {
        final TextView textBMICalc = binding.textBMICalc;
        if (height != 0) {
            double meterHeight = height / 100;
            double bmi = weight / (meterHeight * meterHeight);
            String bmiresult = Double.toString(bmi) ;
            textBMICalc.setText(bmiresult);

        } else {


            textBMICalc.setText("0");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}