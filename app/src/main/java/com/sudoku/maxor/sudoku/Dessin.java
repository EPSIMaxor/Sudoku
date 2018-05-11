package com.sudoku.maxor.sudoku;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;
import java.util.LinkedList;

/**
 * Created by maxor on 26/04/2018.
 */

 class Cercle {
    int xc,yc,rayon;
    private Paint paint;

    public Cercle(int x, int y, int r){
        xc = x;
        yc = y;
        rayon = r;
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(xc,yc,rayon,paint);
    }
}

class Lines {
     int xs,ys,xf,yf;
     private Paint p;
     private float largeur;

     public Lines (int x, int y,int sx, int sy,float largeur) {
         xs = x;
         ys = y;
         xf = sx;
         yf = sy;
         this.largeur = largeur;
         p = new Paint();
         p.setColor(Color.BLUE);
         p.setStrokeWidth(largeur);
     }

     public void draw(Canvas canvas){
         canvas.drawLine(xs,ys,xf,yf,p);
     }
}

public class Dessin extends View implements View.OnTouchListener{
    LinkedList<Cercle> cercles;
    LinkedList<Lines> lines;
    StringBuilder grille = new StringBuilder("008203500009670408346050702430010059967005001000496203280034067703500904004107020");
    StringBuilder values = new StringBuilder(grille);


    public Dessin(Context context, AttributeSet attrs){
        super(context,attrs);
        cercles = new LinkedList<Cercle>();
        int x = 60;
        for(int i = 0; i < 9; i++) {
            cercles.add(new Cercle(x, 1800, 60));
            x = x + 160;
        }

        lines = new LinkedList<Lines>();
        int taille = 153;
        float larg = 2;
        for(int i = 0; i < 10; i++) {
            if(i%3 == 0) {
                larg = 12;
            }
            else {
                larg = 2;
            }
//           colonne vertical
            lines.add(new Lines(taille*i,0,taille*i,taille*9,larg));
//            colone horizontal
            lines.add(new Lines(0,taille*i,taille*9,taille*i,larg));

        }
    }

    @Override
    public void onDraw(Canvas canvas){
        double marge = 0.2;
        int cell = (Resources.getSystem().getDisplayMetrics().widthPixels)/9;
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);

        for(Lines l : lines) {
            l.draw(canvas);
        }

        for (int i =0; i<9;i++){
            for (int j=0;j<9;j++){
                float step1 =i+Float.parseFloat(String.valueOf(marge));
                float step2 =j+Float.parseFloat(String.valueOf(marge));
                if (grille.charAt(i+9*j) != '0'){
                    paint.setTextSize(50);
                    canvas.drawText(""+ grille.charAt(i+9*j),(cell)*(step1),(cell)*(step2)+30,paint);
                }
            }
        }
        for (int i =0; i<9;i++){
            paint.setTextSize(100);
            canvas.drawText(""+(i+1),(cell)*i+20,(cell)*10,paint);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int cases = (Resources.getSystem().getDisplayMetrics().widthPixels)/9;
        int num = 0;

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                int cell_x = x/cases;
                int cell_y = y/cases;
                break;
        }

        this.invalidate();

        return true;
    }

}
