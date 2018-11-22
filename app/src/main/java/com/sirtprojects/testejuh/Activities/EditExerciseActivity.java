package com.sirtprojects.testejuh.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.led_on_off.led.R;
import com.sirtprojects.testejuh.Models.Exercise;

public class EditExerciseActivity extends Activity implements View.OnClickListener{

    private EditText editTextName, editTextDescription;
    private Button[] buttonsCategoria = new Button[3];
    private Button[] buttonsLevel = new Button[4];
    private Button btCancel, btNext;
    private String bufferCategoria, bufferLevel;

    private final Exercise exercise = new Exercise(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_exercise);

        buttonsLevel[0] = findViewById(R.id.button_edit_exercise_facil);
        buttonsLevel[1] = findViewById(R.id.button_edit_exercise_medio);
        buttonsLevel[2] = findViewById(R.id.button_edit_exercise_dificil);
        buttonsLevel[3] = findViewById(R.id.button_edit_exercise_personalizar);

        buttonsCategoria[0] = findViewById(R.id.button_edit_exercise_cone);
        buttonsCategoria[1] = findViewById(R.id.button_edit_exercise_arco);
        buttonsCategoria[2] = findViewById(R.id.button_edit_exercise_escada);

        btCancel = findViewById(R.id.button_edit_exercise_cancel);
        btNext = findViewById(R.id.button_edit_exercise_settime);

        editTextName = findViewById(R.id.edit_text_edit_exercise_name_exercise);
        editTextDescription = findViewById(R.id.edit_text_edit_exercise_description_exercise);

        buttonsLevel[0].setOnClickListener(this);
        buttonsLevel[1].setOnClickListener(this);
        buttonsLevel[2].setOnClickListener(this);
        buttonsLevel[3].setOnClickListener(this);

        buttonsCategoria[0].setOnClickListener(this);
        buttonsCategoria[1].setOnClickListener(this);
        buttonsCategoria[2].setOnClickListener(this);

        btCancel.setOnClickListener(this);
        btNext.setOnClickListener(this);

        if(getIntent().getExtras() != null){
            setTitle(getString(R.string.app_name)); // OLHANDO USUARIO
            //int codigo = getIntent().getExtras().getInt("consulta");
            //usuario.carregaExerciseByCode
            //
        }else{
            setTitle(getString(R.string.app_name)); // INCLUINDO USUÁRIO
        }

    }

    @Override
    public void onClick(View v) {
        if(v != null){
            if(v.getId() == buttonsLevel[0].getId()){
                changeColorsButtons(buttonsLevel, 0);
                bufferLevel = "";
                bufferLevel = "Fácil";
            }
            else if(v.getId() == buttonsLevel[1].getId()){
                changeColorsButtons(buttonsLevel, 1);
                bufferLevel = "";
                bufferLevel = "Médio";
            }
            else if(v.getId() == buttonsLevel[2].getId()){
                changeColorsButtons(buttonsLevel, 2);
                bufferLevel = "";
                bufferLevel = "Difícil";
            }
            else if(v.getId() == buttonsLevel[3].getId()){
                changeColorsButtons(buttonsLevel, 3);
                bufferLevel = "";
                bufferLevel = "Personalizado";
            }
            else if(v.getId() == buttonsCategoria[0].getId()){
                changeColorsButtons(buttonsCategoria, 0);
                bufferCategoria = "";
                bufferCategoria = "Cone";
            }
            else if(v.getId() == buttonsCategoria[1].getId()){
                changeColorsButtons(buttonsCategoria, 1);
                bufferCategoria = "";
                bufferCategoria = "Arco";
            }
            else if(v.getId() == buttonsCategoria[2].getId()){
                changeColorsButtons(buttonsCategoria, 2);
                bufferCategoria = "";
                bufferCategoria = "Escada";
            }
            else if(v.getId() == btCancel.getId()){
                finish();
            }
            else if(v.getId() == btNext.getId()){ // SALVAR
                boolean valido = true;

                exercise.setNome(editTextName.getText().toString());
                exercise.setDescricao(editTextDescription.getText().toString());
                exercise.setCategoria(bufferCategoria);
                exercise.setNivel(bufferLevel);

                if(exercise.getNome().equals("")){
                    editTextName.setError(getString(R.string.obrigatorio));
                    valido = false;
                }
                if(exercise.getDescricao().equals("")){
                    editTextDescription.setError(getString(R.string.obrigatorio));
                    valido = false;
                }

                if(valido){
                    exercise.save();
                    finish();
                }

            }
        }
    }

    private void changeColorsButtons(Button[] butts, int position) {
        for (Button butt : butts) {
            butt.setBackground(getResources().getDrawable(R.drawable.rounded_button_transparent));
        }
        butts[position].setBackground(getResources().getDrawable(R.drawable.rounded_button_green));
    }

}
