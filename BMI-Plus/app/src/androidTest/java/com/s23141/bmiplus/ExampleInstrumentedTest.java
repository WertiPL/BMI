package com.s23141.bmiplus;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import com.s23141.bmiplus.ui.bmi.BMIFragment;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.s23141.bmiplus", appContext.getPackageName());
    }

    @Test
    public void CountBMITest()
    {
        //Given
        int height =150;
        double weight = 75.4;
        //When
        String res;
        res = BMIFragment.calculate(height,weight);
        //Then
        assertEquals("33.51111111111111",res);


    }


}