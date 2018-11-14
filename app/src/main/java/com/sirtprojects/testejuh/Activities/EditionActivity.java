package com.sirtprojects.testejuh.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.led_on_off.led.R;

public class EditionActivity extends Activity implements View.OnClickListener{
    Button btLed1, btLed2, btLed3, btLed4, btStart, btDesligar, btErase, bt5s, bt30s;
    TextView tvCode;
    String buffer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edition);

        btLed1 = findViewById(R.id.button_edition_L1);
        btLed2 = findViewById(R.id.button_edition_L2);
        btLed3 = findViewById(R.id.button_edition_L3);
        btLed4 = findViewById(R.id.button_edition_L4);
        btStart = findViewById(R.id.button_edition_start);
        btDesligar = findViewById(R.id.button_edition_stop);
        btErase = findViewById(R.id.button_edition_restart);
        bt5s = findViewById(R.id.button_edition_5s);
        bt30s = findViewById(R.id.button_edition_30s);
        tvCode = findViewById(R.id.text_view_edition_coding);

        btLed1.setOnClickListener(this);
        btLed2.setOnClickListener(this);
        btLed3.setOnClickListener(this);
        btLed4.setOnClickListener(this);
        btStart.setOnClickListener(this);
        btDesligar.setOnClickListener(this);
        btErase.setOnClickListener(this);
        bt5s.setOnClickListener(this);
        bt30s.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v != null){
            if(v.getId() == btLed1.getId()){
                tvCode.setText(buffer + btLed1.getText() +  " ");
                buffer = tvCode.getText().toString();

            }
            else if(v.getId() == btLed2.getId()){
                tvCode.setText(buffer + btLed2.getText() + " ");
                buffer = tvCode.getText().toString();

            }
            else if(v.getId() == btLed3.getId()){
                tvCode.setText(buffer + btLed3.getText() + " ");
                buffer = tvCode.getText().toString();

            }
            else if(v.getId() == btLed4.getId()){
                tvCode.setText(buffer + btLed4.getText() + " ");
                buffer = tvCode.getText().toString();

            }
            else if(v.getId() == btStart.getId()){
                tvCode.setText(buffer + btStart.getText() + " ");
                buffer = tvCode.getText().toString();

            }
            else if(v.getId() == btDesligar.getId()){
                tvCode.setText(buffer + btDesligar.getText() + " ");
                buffer = tvCode.getText().toString();

            }
            else if(v.getId() == btErase.getId()){
                tvCode.setText("");
                buffer = "";

            }
            else if(v.getId() == bt5s.getId()){
                tvCode.setText(buffer + bt5s.getText() + " ");
                buffer = tvCode.getText().toString();

            }
            else if(v.getId() == bt30s.getId()){
                tvCode.setText(buffer + bt30s.getText() + " ");
                buffer = tvCode.getText().toString();

            }
        }
    }
}
