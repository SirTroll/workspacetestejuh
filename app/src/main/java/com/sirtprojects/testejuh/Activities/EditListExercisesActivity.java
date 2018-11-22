package com.sirtprojects.testejuh.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.led_on_off.led.R;
import com.sirtprojects.testejuh.Models.Exercise;

import java.util.ArrayList;

public class EditListExercisesActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

    private ListView listViewExercises;
    private Button btVoltar;
    private TextView tvDescription;
    private ExerciseAdapter exerciseAdapter;
    private ArrayList<Exercise> exercises;
    private AlertDialog alerta;
    private Exercise exerciseEdicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list_exercises);

        listViewExercises = findViewById(R.id.expandable_list_view_edit_list_exercises);
        btVoltar = findViewById(R.id.button_edit_list_exercise);
        tvDescription = findViewById(R.id.text_view_edit_list_exercises);

        listViewExercises.setOnItemClickListener(this);
        btVoltar.setOnClickListener(this);
        tvDescription.setOnClickListener(this);

        exercises = new Exercise(this).getExercises();
        exerciseAdapter = new ExerciseAdapter(this, exercises);
        listViewExercises.setAdapter(exerciseAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v != null){
            if(v.getId() == btVoltar.getId())
                finish();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Exercise exercise = exercises.get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Descrição");
        builder.setMessage(exercise.getDescricao());
        builder.setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                exercise.delete();
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });
        builder.setPositiveButton("Fechar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                alerta.dismiss();
            }
        });
        alerta = builder.create();
        alerta.show();

        exerciseEdicao = exercise;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(exerciseEdicao != null){
            exerciseEdicao.exercicioByCode(exerciseEdicao.getCodigo());
            if(exerciseEdicao.isExcluir()){
                exercises.remove(exerciseEdicao);
            }
            exerciseAdapter.notifyDataSetChanged();
        }
    }
}