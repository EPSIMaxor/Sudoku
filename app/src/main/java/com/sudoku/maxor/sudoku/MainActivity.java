package com.sudoku.maxor.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int chiffre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chiffre = 0;

    }


    private View.OnClickListener btnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }

    };
}
