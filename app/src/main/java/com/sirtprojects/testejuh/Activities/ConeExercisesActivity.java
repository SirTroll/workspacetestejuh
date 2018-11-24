package com.sirtprojects.testejuh.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.led_on_off.led.R;
import com.sirtprojects.testejuh.Adapters.ExerciseAdapter;
import com.sirtprojects.testejuh.Models.Exercise;

import java.util.ArrayList;

public class ConeExercisesActivity extends Activity implements AdapterView.OnItemClickListener{

    ListView listViewCones;
    ExerciseAdapter exerciseAdapter;
    private ArrayList<Exercise> exercises;
    private AlertDialog alerta;
    private Exercise exerciseEdicao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cone_exercises);

        listViewCones = findViewById(R.id.list_view_cone);

        listViewCones.setOnItemClickListener(this);

        exercises = new Exercise(this).getExercises();
        exerciseAdapter = new ExerciseAdapter(this, exercises);
        listViewCones.setAdapter(exerciseAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(listViewCones.getContext(),
                "Posição Selecionada:" + position, Toast.LENGTH_LONG)
                .show();
    }
}
