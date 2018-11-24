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
import android.widget.ImageButton;

import com.led_on_off.led.R;

import java.util.Objects;

/**
 * Criado por Felipe Campos on 22/11/2018.
 */
public class TrainingFragment extends Fragment implements View.OnClickListener{

    ImageButton btCone, btArc, btStairs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_training, container, false);


        btCone = view.findViewById(R.id.image_button_fragment_edit_training_cone);
        btArc = view.findViewById(R.id.image_button_fragment_edit_training_arc);
        btStairs = view.findViewById(R.id.image_button_fragment_edit_training_stairs);

        btCone.setOnClickListener(this);
        btArc.setOnClickListener(this);
        btStairs.setOnClickListener(this);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btCone.getId()){
            FragmentManager fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
            FragmentTransaction transaction = fragmentTransaction.beginTransaction();

            ConeFragment coneFragment = new ConeFragment();

            transaction.replace(R.id.container_fragment, coneFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }
        else if(v.getId() == btArc.getId()){
            FragmentManager fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
            FragmentTransaction transaction = fragmentTransaction.beginTransaction();

            ArcFragment arcFragment = new ArcFragment();

            transaction.replace(R.id.container_fragment, arcFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }
        else if(v.getId() == btStairs.getId()){
            FragmentManager fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
            FragmentTransaction transaction = fragmentTransaction.beginTransaction();

            StairsFragment stairsFragment = new StairsFragment();

            transaction.replace(R.id.container_fragment, stairsFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }
    }
}
