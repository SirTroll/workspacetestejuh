package com.sirtprojects.testejuh.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.led_on_off.led.R;
import com.sirtprojects.testejuh.Fragments.TrainingFragment;

public class EditTrainingActivity extends FragmentActivity implements View.OnClickListener {

    Button btCancel, btFinish;
    ImageButton btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_training);

        btCancel = findViewById(R.id.button_edit_training_cancelar);
        btFinish = findViewById(R.id.button_edit_training_finalizar);
        btAdd = findViewById(R.id.image_button_edit_training_add);

        btCancel.setOnClickListener(this);
        btFinish.setOnClickListener(this);
        btAdd.setOnClickListener(this);

        btAdd.setVisibility(View.VISIBLE);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        TrainingFragment trainingFragment = new TrainingFragment();
        fragmentTransaction.add(R.id.container_fragment, trainingFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onClick(View v) {
        if(v != null){
            if(v.getId() == btCancel.getId()){
                onBackPressed();
            }
            else if(v.getId() == btFinish.getId()){


            }
            else if(v.getId() == btAdd.getId()){

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                TrainingFragment trainingFragment = new TrainingFragment();
                fragmentTransaction.add(R.id.container_fragment, trainingFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

        }
    }

    @Override
    public void onBackPressed() {
        SharedPreferences preferences = this.getSharedPreferences("PREFERENCES", 0);
        SharedPreferences preferencesCone = this.getSharedPreferences("PREFERENCESCONE", 0);
        SharedPreferences preferencesArc = this.getSharedPreferences("PREFERENCESARC", 0);
        SharedPreferences preferencesStairs = this.getSharedPreferences("PREFERENCESSTAIRS", 0);

        SharedPreferences.Editor editor = preferences.edit();
        SharedPreferences.Editor editorCone = preferencesCone.edit();
        SharedPreferences.Editor editorArc = preferencesArc.edit();
        SharedPreferences.Editor editorStairs = preferencesStairs.edit();
        editor.clear();
        editorCone.clear();
        editorArc.clear();
        editorStairs.clear();
        editor.commit();
        editorCone.commit();
        editorArc.commit();
        editorStairs.commit();
        finish();
    }
}
