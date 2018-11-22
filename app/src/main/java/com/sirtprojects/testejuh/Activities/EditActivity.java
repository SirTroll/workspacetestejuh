package com.sirtprojects.testejuh.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.led_on_off.led.R;

public class EditActivity extends Activity implements View.OnClickListener{

    Button btAdd, btConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btAdd = findViewById(R.id.button_edit_activity_add_exercise);
        btConsulta = findViewById(R.id.button_edit_activity_consulta_exercicios);

        btAdd.setOnClickListener(this);
        btConsulta.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btAdd.getId()){
            Intent intent = new Intent(EditActivity.this, EditExerciseActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == btConsulta.getId()){
            Intent intent = new Intent(EditActivity.this, EditListExercisesActivity.class);
            startActivity(intent);
        }

    }
}
