package com.s23141.bmiplus.ui.Calories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CaloriesViewModel extends ViewModel {

    private final MutableLiveData<Double> height;
    private final MutableLiveData<Double> weight;
    private final MutableLiveData<Boolean> gender;
    private final MutableLiveData<String> mText;

    public CaloriesViewModel() {
        height = new MutableLiveData<>(0.0);
        weight = new MutableLiveData<>(0.0);
        gender = new MutableLiveData<>();
        mText = new MutableLiveData<>();
        mText.setValue("Wzór Harrisa Benedicta Obliczanie zapotrzebowania kcal");
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