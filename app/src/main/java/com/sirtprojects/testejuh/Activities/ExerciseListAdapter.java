package com.sirtprojects.testejuh.Activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.sirtprojects.testejuh.Models.Exercise;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Criado por Felipe Campos on 20/11/2018.
 */
public class ExerciseListAdapter extends BaseExpandableListAdapter {

    private ArrayList<Exercise> exercises;
    private HashMap<String, ArrayList<Exercise>> listHashMap;

    public ExerciseListAdapter(ArrayList<Exercise> exercises, HashMap<String, ArrayList<Exercise>> listHashMap) {
        this.exercises = exercises;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return exercises.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listHashMap.get(exercises.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return exercises.get(i);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listHashMap.get(exercises.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup viewGroup) {

        String headerTitle = (String) getGroup(groupPosition);
        if(view == null){
           // LayoutInflater inflater = this.
        }

        return null;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
