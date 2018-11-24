package com.sirtprojects.testejuh.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.led_on_off.led.R;
import com.sirtprojects.testejuh.Fragments.TrainingFragment;

public class EditTrainingActivity extends FragmentActivity implements View.OnClickListener {

    Button btCancel, btFinish;
    RecyclerView recyclerTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_training);

        btCancel = findViewById(R.id.button_edit_training_cancelar);
        btFinish = findViewById(R.id.button_edit_training_finalizar);
        recyclerTag = findViewById(R.id.recycler_view_edit_training);

        recyclerTag.setLayoutManager(new GridLayoutManager(this, 3));

        //recyclerTag.setAdapter();
        //recyclerTag.setHasFixedSize(true);
        //recyclerTag.addItemDecoration();

        btCancel.setOnClickListener(this);
        btFinish.setOnClickListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        TrainingFragment trainingFragment = new TrainingFragment();
        fragmentTransaction.add(R.id.container_fragment, trainingFragment);
        fragmentTransaction.commit();

    }


    @Override
    public void onClick(View v) {
        if(v != null){
            if(v.getId() == btCancel.getId()){
                finish();
            }
            else if(v.getId() == btFinish.getId()){
                //implementar
            }

        }
    }
}
