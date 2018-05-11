package com.sudoku.maxor.sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

public class GetGrilleActivity extends AppCompatActivity {
    private Vgrilles grilles;
    private Grille grille;
    private ListView lvGrille;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getgrille);
        Bundle bl = this.getIntent().getExtras();
        int lvl = bl.getInt("lvlinfo");
        grilles = new Vgrilles();
        try {
            grilles.generateGrille(getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        }

        lvGrille = (ListView) findViewById(R.id.lvGrille);
        MyAdapter adapter = new MyAdapter(this, grilles.getVgrille(1));
//        ArrayAdapter<Grille> arrayAdapter = new ArrayAdapter<Grille>(this, android.R.layout.simple_list_item_1, grilles.getVgrille(1));
        lvGrille.setAdapter(adapter);
        lvGrille.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Item -->", lvGrille.getItemAtPosition(i).toString());
                Bundle b = new Bundle();
                grille = (Grille) lvGrille.getItemAtPosition(i);
                b.putString("resGrille", grille.getRes());
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });

    }

}
