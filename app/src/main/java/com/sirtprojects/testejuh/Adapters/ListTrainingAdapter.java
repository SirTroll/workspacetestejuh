package com.sirtprojects.testejuh.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.led_on_off.led.R;
import com.sirtprojects.testejuh.Models.ExercicioLista;

import java.util.List;

/**
 * Criado por Felipe Campos on 26/11/2018.
 */
public class ListTrainingAdapter extends ArrayAdapter<ExercicioLista> {

    private Context context;
    private List<ExercicioLista> exercicioListaList = null;

    public ListTrainingAdapter(Context context,  List<ExercicioLista> exercicioListas) {
        super(context,0, exercicioListas);
        this.exercicioListaList = exercicioListas;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {

        ExercicioLista exercicioLista = exercicioListaList.get(position);

        if(view == null)
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_edit_list_exercises, null);

        TextView tvName = view.findViewById(R.id.item_text_view_name);
        TextView tvCategory = view.findViewById(R.id.item_text_view_category);
        TextView tvNivel = view.findViewById(R.id.item_text_view_nivel);

        tvName.setText(exercicioLista.getName());
        tvCategory.setText(exercicioLista.getCategoria());
        tvNivel.setText(exercicioLista.getNivel());


        return view;
    }
}
