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
import com.sirtprojects.testejuh.Models.Exercise;

import java.util.ArrayList;

/**
 * Criado por Felipe Campos on 20/11/2018.
 */
public class ExerciseAdapter extends ArrayAdapter {

    private ArrayList<Exercise> exercises;

    public ExerciseAdapter(@NonNull Context context, @NonNull ArrayList<Exercise> exercises) {
        super(context, 0, exercises);
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Exercise exercise = exercises.get(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_edit_list_exercises, null);

        TextView tvName = convertView.findViewById(R.id.item_text_view_name);
        TextView tvCategory = convertView.findViewById(R.id.item_text_view_category);
        TextView tvNivel = convertView.findViewById(R.id.item_text_view_nivel);

        tvName.setText(exercise.getNome());
        tvCategory.setText(exercise.getCategoria());
        tvNivel.setText(exercise.getNivel());

        return convertView;

    }
}
