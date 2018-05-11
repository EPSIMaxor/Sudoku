package com.sudoku.maxor.sudoku;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxor on 24/04/2018.
 */

public class Vgrilles {
    private List<Grille> vgrille;

    public Vgrilles(){
        setVgrille(new ArrayList<Grille>());
    }

    public List<Grille> getVgrille(int lvl) {
        List<Grille> grilles = new ArrayList<Grille>();
        for (Grille g : vgrille) {
            if(g.getLvl() == lvl){
                grilles.add(g);
            }
        }
        return grilles;
    }

    public Grille getGrille(int num) {
        Grille grille = new Grille();
        for (Grille g : vgrille) {
            if(g.getNum() == num){
                grille = g;
            }
        }
        return grille;
    }

    public void setVgrille(List<Grille> vgrille) {
        this.vgrille = vgrille;
    }

    public void generateGrille(Context c) throws IOException {

        InputStream file = c.getResources().openRawResource(R.raw.lines);
        BufferedReader br = new BufferedReader(new InputStreamReader(file));
        Log.e("readText --> ", "read file with buffer reader");
        String line;
        int cpt = 0;

        try {
            while ((line = br.readLine()) != null && cpt < 10){
                cpt++;
                Grille g = new Grille(1, cpt, line);
                vgrille.add(g);
            }
        }
        catch (IOException e){
            Log.e("Error", "Error read file grille");
        }
        finally {
            br.close();
        }

    }
}
