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
import com.sirtprojects.testejuh.Models.Treino;

import java.util.ArrayList;

/**
 * Criado por Felipe Campos on 26/11/2018.
 */
public class TrainingAdapter extends ArrayAdapter {

    private ArrayList<Treino> treinos;

    public TrainingAdapter(@NonNull Context context, @NonNull ArrayList<Treino> treinos) {
        super(context, 0, treinos);
        this.treinos = treinos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Treino treino = treinos.get(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_edit_list_exercises, null);

        TextView tvName = convertView.findViewById(R.id.item_text_view_name);
        TextView tvCategory = convertView.findViewById(R.id.item_text_view_category);
        TextView tvNivel = convertView.findViewById(R.id.item_text_view_nivel);

        tvName.setText(treino.getExercicios_treino());

        return convertView;
    }
}
