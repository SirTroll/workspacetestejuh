package com.sirtprojects.testejuh.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.led_on_off.led.R;

public class EditExerciseActivity extends Activity implements View.OnClickListener{

    Button[] buttonsCategoria = new Button[3];
    Button[] buttonsLevel = new Button[4];

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

        buttonsLevel[0].setOnClickListener(this);
        buttonsLevel[1].setOnClickListener(this);
        buttonsLevel[2].setOnClickListener(this);
        buttonsLevel[3].setOnClickListener(this);

        buttonsCategoria[0].setOnClickListener(this);
        buttonsCategoria[1].setOnClickListener(this);
        buttonsCategoria[2].setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v != null){
            if(v.getId() == buttonsLevel[0].getId()){
                changeColorsButtons(buttonsLevel, 0);
            }
            else if(v.getId() == buttonsLevel[1].getId()){
                changeColorsButtons(buttonsLevel, 1);
            }
            else if(v.getId() == buttonsLevel[2].getId()){
                changeColorsButtons(buttonsLevel, 2);
            }
            else if(v.getId() == buttonsLevel[3].getId()){
                changeColorsButtons(buttonsLevel, 3);
            }
            else if(v.getId() == buttonsCategoria[0].getId()){
                changeColorsButtons(buttonsCategoria, 0);
            }
            else if(v.getId() == buttonsCategoria[1].getId()){
                changeColorsButtons(buttonsCategoria, 1);
            }
            else if(v.getId() == buttonsCategoria[2].getId()){
                changeColorsButtons(buttonsCategoria, 2);
            }
        }
    }

    private void changeColorsButtons(Button[] butts, int position) {
        for(int i = 0; i < butts.length; i++){
            butts[i].setBackground(getResources().getDrawable(R.drawable.rounded_button_transparent));
        }
        butts[position].setBackground(getResources().getDrawable(R.drawable.rounded_button_green));
    }

}
