package com.s23141.bmiplus.ui.Calories;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.s23141.bmiplus.R;
import com.s23141.bmiplus.databinding.FragmentCaloriesBinding;

public class CaloriesFragment extends Fragment {

    private FragmentCaloriesBinding binding;
    private double weight = 0.0;
    private double height = 0.15;
    private  float age = 0;
    private Boolean gender = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CaloriesViewModel caloriesViewModel =
                new ViewModelProvider(this).get(CaloriesViewModel.class);

        binding = FragmentCaloriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        EditText heightEditView = binding.InputHeight;
        EditText weightEditView = binding.InputWeight;
        EditText ageEditView = binding.InputWeight;
        RadioButton female = binding.radioButton1;
        RadioButton male = binding.radioButton2;
        RadioGroup radioGroup = binding.radioGroup;
        EditText age = binding.age;
        Button buttonCalc = binding.button;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton1) {
                    gender = false; //  female
                } else if (checkedId == R.id.radioButton2) {

                    gender = true; //  male
                }
            }
        });


        heightEditView.addTextChangedListener(HeightEditTextWatcher);
        weightEditView.addTextChangedListener(WeightEditTextWatcher);
        ageEditView.addTextChangedListener(AgeEditTextWatcher);
        final TextView textView = binding.textCalories;
        caloriesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        buttonCalc.setOnClickListener(v -> calculateBenedicta());

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
    private final TextWatcher AgeEditTextWatcher = new TextWatcher() {
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

    };

    private void calculateBenedicta() {
        final TextView textCalories = binding.textCalories;

        double Benedicta;
        if (!gender) {
            Benedicta  = (weight*10) + (6.25 *height) - (5*age) -161;
        } else {
            Benedicta  = (weight*10) + (6.25 *height) - (5*age) +5;
        }
        String benedictaResult = Double.toString(Benedicta) ;
        textCalories.setText(benedictaResult);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}