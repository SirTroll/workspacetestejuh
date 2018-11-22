package com.sirtprojects.testejuh.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.led_on_off.led.R;

/**
 * Criado por Felipe Campos on 22/11/2018.
 */
public class TrainingFragment extends Fragment implements View.OnClickListener{

    ImageButton btCone;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_training, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btCone = view.findViewById(R.id.image_button_fragment_edit_training_cone);

        btCone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btCone.getId()){
            Toast.makeText(getActivity(),"TESTEBUTTON",Toast.LENGTH_SHORT).show();

            FragmentManager fragmentTransaction = getActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentTransaction.beginTransaction();

            TesteFragment testeFragment = new TesteFragment();

            transaction.replace(R.id.container_fragment, testeFragment);
            transaction.addToBackStack(null);

            transaction.commit();

        }
    }
}
