package com.sirtprojects.testejuh.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.led_on_off.led.R;

public class MainActivity extends Activity implements View.OnClickListener {

    ImageButton btEdit, btTraining, btNewTraining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btTraining = findViewById(R.id.image_button_main_training);
        btNewTraining = findViewById(R.id.image_button_main_new_train);
        btEdit = findViewById(R.id.image_button_main_edit_exercise);

        btTraining.setOnClickListener(this);
        btNewTraining.setOnClickListener(this);
        btEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v != null){
            if(v.getId() == btTraining.getId()){
                Intent intent = new Intent(MainActivity.this, TrainingsActivity.class);
                startActivity(intent);
            }
            else if(v.getId() == btNewTraining.getId()){
                Intent intent = new Intent(MainActivity.this, EditTrainingActivity.class);
                startActivity(intent);
            }
            else if(v.getId() == btEdit.getId()){
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                startActivity(intent);
            }
        }
    }
}
