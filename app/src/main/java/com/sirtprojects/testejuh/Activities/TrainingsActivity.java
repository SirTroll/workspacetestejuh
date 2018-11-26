package com.sirtprojects.testejuh.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.led_on_off.led.R;

public class TrainingsActivity extends Activity implements AdapterView.OnItemClickListener {

    ListView listViewTrainings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainings);

        listViewTrainings = findViewById(R.id.list_view_trainings);

        listViewTrainings.setOnItemClickListener(this);

        //listViewTrainings.setAdapter();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //INICIAR O TREINO

    }
}
