package com.sirtprojects.testejuh.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.led_on_off.led.R;

public class MainActivity extends Activity implements View.OnClickListener {

    ImageButton btEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btEdit = findViewById(R.id.image_button_edit);

        btEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v != null){
            if(v.getId() == btEdit.getId()){
                Intent intent = new Intent(MainActivity.this, EditExerciseActivity.class);
                startActivity(intent);
            }
        }
    }
}
