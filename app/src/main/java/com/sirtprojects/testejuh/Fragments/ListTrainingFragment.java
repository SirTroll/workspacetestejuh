package com.sirtprojects.testejuh.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.led_on_off.led.R;
import com.sirtprojects.testejuh.Adapters.ListTrainingAdapter;
import com.sirtprojects.testejuh.Models.ExercicioLista;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListTrainingFragment extends Fragment {

    private ListView listViewTraining;
    Button btFinalizado;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_training, container, false);

        btFinalizado = view.findViewById(R.id.button_list_training_terminado);
        listViewTraining = view.findViewById(R.id.list_view_fragment_list_training);

        final List<ExercicioLista> exercicioListas = gerarExercicio();
        ListTrainingAdapter listTrainingAdapter = new ListTrainingAdapter(getContext(), exercicioListas);
        listViewTraining.setAdapter(listTrainingAdapter);

        btFinalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return  view;
    }

    private List<ExercicioLista> gerarExercicio(){
        List<ExercicioLista> exercicios = new ArrayList<>();

        SharedPreferences preferences = getContext().getSharedPreferences("PREFERENCES", 0);
        SharedPreferences.Editor editor = preferences.edit();

        if(preferences.getString("nomeCone", null) != null) {
            exercicios.add(criarExercicio(preferences.getString("nomeCone", null),
                    preferences.getString("nivelCone", null),
                    preferences.getString("categoriaCone", null),
                    preferences.getString("descricaoCone", null))
            );}
        if(preferences.getString("nomeArc", null) != null){
            exercicios.add(criarExercicio(preferences.getString("nomeArc", null),
                    preferences.getString("nivelArc", null),
                    preferences.getString("categoriaArc", null),
                    preferences.getString("descricaoArc", null))
            );}
        if(preferences.getString("nomeStairs", null) != null){
            exercicios.add(criarExercicio(preferences.getString("nomeStairs", null),
                    preferences.getString("nivelStairs", null),
                    preferences.getString("categoriaStairs", null),
                    preferences.getString("descricaoStairs", null))
            );}

        return exercicios;

    }

    private ExercicioLista criarExercicio(String nome, String nivel, String categoria, String descricao){
        ExercicioLista exercicioLista = new ExercicioLista(nome, nivel, categoria, descricao);
        return exercicioLista;
    }



}
