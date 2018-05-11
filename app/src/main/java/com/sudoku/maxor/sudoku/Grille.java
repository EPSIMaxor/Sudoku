package com.sudoku.maxor.sudoku;

import java.io.Serializable;

/**
 * Created by maxor on 24/04/2018.
 */

public class Grille implements Serializable{
    private int lvl;
    private int num;
    private String res;
    private boolean done;
    private int pourcentage;

    public Grille(int lvl, int num, String res){
        this.setLvl(lvl);
        this.setNum(num);
        this.res = res;
        setDone(false);
        setPourcentage(0);
    }

    public Grille(){

    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    @Override
    public String toString(){
        return "Lvl : "+ this.lvl + "num : "+ this.num + "res : "+ this.res;
    }
}
