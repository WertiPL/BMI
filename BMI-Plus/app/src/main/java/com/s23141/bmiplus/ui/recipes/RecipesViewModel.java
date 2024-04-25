package com.s23141.bmiplus.ui.recipes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class RecipesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecipesViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("This is Recipes fragment");
    }


    public LiveData<String> getText() {
        return mText;
    }
}