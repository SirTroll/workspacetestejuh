package com.sirtprojects.testejuh.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import java.util.Objects;

/**
 * Criado por Felipe Campos on 22/11/2018.
 */
public class StairsFragment extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ListView listViewStairs;
    private ExerciseAdapter exerciseAdapter;
    private ArrayList<Exercise> exercises;
    private Context context;
    private AlertDialog alerta;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stairs, container, false);

        listViewStairs = view.findViewById(R.id.list_view_fragment_stairs);

        listViewStairs.setOnItemClickListener(this);
        listViewStairs.setOnItemLongClickListener(this);

        preferences = getContext().getSharedPreferences("MyPrefs", 0);
        editor = preferences.edit();

        exercises = new Exercise(context).getExercisesByCategory("Escada");
        exerciseAdapter = new ExerciseAdapter(context, exercises);
        listViewStairs.setAdapter(exerciseAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(listViewStairs.getContext(),
                "Posição Selecionada:" + position, Toast.LENGTH_LONG)
                .show();

        //SALVANDO
        final Exercise exercise = exercises.get(position);

        int codigo = exercise.getCodigo();
        String nome = exercise.getNome();
        String categoria = exercise.getCategoria();
        String nivel = exercise.getNivel();
        String descricao = exercise.getDescricao();

        editor.putInt("codigoStairs", codigo);
        editor.putString("nomeStairs", nome);
        editor.putString("categoriaStairs", categoria);
        editor.putString("nivelStairs", nivel);
        editor.putString("descricaoStairs", descricao);

        //PRÓXIMO FRAGMENT
        //AQUI

        FragmentManager fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
        FragmentTransaction transaction = fragmentTransaction.beginTransaction();

        TrainingFragment trainingFragment = new TrainingFragment();

        transaction.replace(R.id.container_fragment, trainingFragment);
        transaction.addToBackStack(null);

        transaction.commit();

    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        final Exercise exercise = exercises.get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Descrição");
        builder.setMessage(exercise.getDescricao());
        builder.setPositiveButton("Fechar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                alerta.dismiss();
            }
        });
        alerta = builder.create();
        alerta.show();
        return true;
    }
}
