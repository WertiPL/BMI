package com.example.bmiplus.ui.bmi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BMIViewModel extends ViewModel {


    private final MutableLiveData<Double> height;
    private final MutableLiveData<Double> weight;
    private final MutableLiveData<String> bmi;
    private final MutableLiveData<String> mText;
    public BMIViewModel() {
        height = new MutableLiveData<>(0.0);
        weight = new MutableLiveData<>(0.0);
        bmi = new MutableLiveData<>();
        mText = new MutableLiveData<>();
        mText.setValue("This is BMI fragment");
    }

    public double getHeight() {
        return height.getValue() != null ? height.getValue() : 0.0;
    }

    public double getWeight() {
        return weight.getValue() != null ? weight.getValue() : 0.0;
    }

    public LiveData<String> getText() {
        return mText;
    }

}