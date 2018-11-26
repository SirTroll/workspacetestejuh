package com.sirtprojects.testejuh.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.led_on_off.led.R;
import com.sirtprojects.testejuh.Adapters.ExerciseAdapter;
import com.sirtprojects.testejuh.Adapters.ListTrainingAdapter;
import com.sirtprojects.testejuh.Models.ExercicioLista;
import com.sirtprojects.testejuh.Models.Exercise;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListTrainingFragment extends Fragment {

    private ListView listViewTraining;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_training, container, false);

        listViewTraining = view.findViewById(R.id.list_view_fragment_list_training);

        List<ExercicioLista> exercicioListas = gerarExercicio();
        ListTrainingAdapter listTrainingAdapter = new ListTrainingAdapter(getContext(), exercicioListas);
        listViewTraining.setAdapter(listTrainingAdapter);


        return  view;
    }

    private List<ExercicioLista> gerarExercicio(){
        List<ExercicioLista> exercicios = new ArrayList<ExercicioLista>();

        SharedPreferences preferences = getContext().getSharedPreferences("PREFERENCES", 0);
        SharedPreferences.Editor editor = preferences.edit();

        exercicios.add(criarExercicio(preferences.getString("nomeCone", null),
                preferences.getString("nivelCone", null),
                preferences.getString("categoriaCone", null),
                preferences.getString("descricaoCone", null))
        );

        return exercicios;

    }

    private ExercicioLista criarExercicio(String nome, String nivel, String categoria, String descricao){
        ExercicioLista exercicioLista = new ExercicioLista(nome, nivel, categoria, descricao);
        return exercicioLista;
    }



}
