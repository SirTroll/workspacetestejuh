package com.sirtprojects.testejuh.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import java.util.Map;

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

        SharedPreferences preferencesCone = getContext().getSharedPreferences("PREFERENCESCONE", 0);
        SharedPreferences preferencesArc = getContext().getSharedPreferences("PREFERENCESARC", 0);
        SharedPreferences preferencesStairs = getContext().getSharedPreferences("PREFERENCESSTAIRS", 0);
        SharedPreferences.Editor editorCone = preferencesCone.edit();
        SharedPreferences.Editor editorArc = preferencesArc.edit();
        SharedPreferences.Editor editorStairs = preferencesStairs.edit();

        if(preferencesCone.getString("nomeCone", null) != null) {
            String nomeCone = preferencesCone.getString("nomeCone", null);
            String nivelCone = preferencesCone.getString("nivelCone", null);
            String categoriaCone = preferencesCone.getString("categoriaCone", null);
            String descricaoCone = preferencesCone.getString("descricaoCone", null);

            String nomeBackup = preferencesCone.getString("nomeBackup", null);
            String nivelBackup = preferencesCone.getString("nivelBackup", null);
            String categoriaBackup = preferencesCone.getString("categoriaBackup", null);
            String descricaoBackup = preferencesCone.getString("descricaoBackup", null);

            if(!nomeCone.equals(nomeBackup)
                    || !categoriaCone.equals(categoriaBackup)
                    || !nivelCone.equals(nivelBackup)
                    || !descricaoCone.equals(descricaoBackup) ){

                Map<String, ?> allEntries = preferencesCone.getAll();

                for(Map.Entry<String, ?> entry : allEntries.entrySet()){
                    Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());

                }

                exercicios.add(criarExercicio(nomeCone, nivelCone, categoriaCone, descricaoCone));
                exercicios.add(criarExercicio(nomeCone, nivelCone, categoriaCone, descricaoCone));
                exercicios.add(criarExercicio(nomeCone, nivelCone, categoriaCone, descricaoCone));

                editorCone.putString("nomeBackup", nomeCone);
                editorCone.putString("nivelBackup", nivelCone);
                editorCone.putString("categoriaBackup", categoriaCone);
                editorCone.putString("descricaoBackup", descricaoBackup);

                editorCone.apply();
            }

            else{

            }
        }

        if(preferencesArc.getString("nomeArc", null) != null){
            exercicios.add(criarExercicio(preferencesArc.getString("nomeArc", null),
                    preferencesArc.getString("nivelArc", null),
                    preferencesArc.getString("categoriaArc", null),
                    preferencesArc.getString("descricaoArc", null))
            );}

        if(preferencesStairs.getString("nomeStairs", null) != null){
            exercicios.add(criarExercicio(preferencesStairs.getString("nomeStairs", null),
                    preferencesStairs.getString("nivelStairs", null),
                    preferencesStairs.getString("categoriaStairs", null),
                    preferencesStairs.getString("descricaoStairs", null))
            );}

        return exercicios;

    }

    private ExercicioLista criarExercicio(String nome, String nivel, String categoria, String descricao){
        ExercicioLista exercicioLista = new ExercicioLista(nome, nivel, categoria, descricao);
        return exercicioLista;
    }



}
