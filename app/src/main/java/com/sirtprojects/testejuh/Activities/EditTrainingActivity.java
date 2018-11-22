package com.sirtprojects.testejuh.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.led_on_off.led.R;
import com.sirtprojects.testejuh.Fragments.TesteFragment;
import com.sirtprojects.testejuh.Fragments.TrainingFragment;

public class EditTrainingActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_training);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        TrainingFragment trainingFragment = new TrainingFragment();
        fragmentTransaction.add(R.id.container_fragment, trainingFragment);
        fragmentTransaction.commit();

        //TRABALHAR COM FRAGMENTS


    }

    public void clickCone(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        TesteFragment testeFragment = new TesteFragment();

        transaction.replace(R.id.container_fragment, testeFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
