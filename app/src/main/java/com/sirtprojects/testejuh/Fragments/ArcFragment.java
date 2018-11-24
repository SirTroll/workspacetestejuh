package com.sirtprojects.testejuh.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.led_on_off.led.R;
import com.sirtprojects.testejuh.Adapters.ExerciseAdapter;
import com.sirtprojects.testejuh.Models.Exercise;

import java.util.ArrayList;

/**
 * Criado por Felipe Campos on 22/11/2018.
 */
public class ArcFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listViewArc;
    private ExerciseAdapter exerciseAdapter;
    private ArrayList<Exercise> exercises;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_arc, container, false);

        listViewArc = view.findViewById(R.id.list_view_fragment_arc);

        listViewArc.setOnItemClickListener(this);

        exercises = new Exercise(context).getExercisesByCategory("Arco");
        exerciseAdapter = new ExerciseAdapter(context, exercises);
        listViewArc.setAdapter(exerciseAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(listViewArc.getContext(),
                "Posição Selecionada:" + position, Toast.LENGTH_LONG)
                .show();
    }


    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }
}
