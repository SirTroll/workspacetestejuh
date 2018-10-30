package com.sirtprojects.testejuh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.led_on_off.led.R;

public class TestsActivity extends Activity implements View.OnClickListener {

    Button btComandos, btListaDispositivos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        btComandos = findViewById(R.id.button_tests_comandos);
        btListaDispositivos = findViewById(R.id.button_tests_lista_dispositivos);

        btComandos.setOnClickListener(this);
        btListaDispositivos.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if(v != null){
            if(v.getId() == btComandos.getId()){
                Intent intent = new Intent(TestsActivity.this, ledControl.class);
                startActivity(intent);
            }
            else if(v.getId() == btListaDispositivos.getId()){
                Intent intent = new Intent(TestsActivity.this, DeviceList.class);
                startActivity(intent);
            }
        }
    }
}
