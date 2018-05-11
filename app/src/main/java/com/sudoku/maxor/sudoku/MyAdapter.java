package com.sudoku.maxor.sudoku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxor on 26/04/2018.
 */

public class MyAdapter extends BaseAdapter{
    private Context context;
    private List<Grille> grilles;

    public MyAdapter(Context context, List<Grille> grilles) {
        this.context = context;
        this.grilles = grilles;
    }

    @Override
    public int getCount() {
        return grilles.size();
    }

    @Override
    public Object getItem(int position) {
        return grilles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = (View) inflater.inflate(R.layout.lv_grilles, null);

        }

        TextView id = (TextView) convertView.findViewById(R.id.tvid);
        TextView lvl = (TextView) convertView.findViewById(R.id.tvlvl);
        TextView pourcentages = (TextView) convertView.findViewById(R.id.tvpourcentages);

        String sid = "Sudoku n° " + String.valueOf(grilles.get(position).getNum());
        String slvl = "Niveau n° " + String.valueOf(grilles.get(position).getLvl());
        String spour = String.valueOf(grilles.get(position).getPourcentage()) + " %";

        id.setText(sid);
        lvl.setText(slvl);
        pourcentages.setText(spour);

        return convertView;
    }
}
