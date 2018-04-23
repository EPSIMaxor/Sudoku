package com.sudoku.maxor.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvNumb;
    private Button btnPlus;
    private int chiffre;
    private String test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNumb = (TextView) findViewById(R.id.tvNumb);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(btnclick);
        chiffre = 0;

    }


    private View.OnClickListener btnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chiffre = chiffre + 1;
            tvNumb.setText("Nombre : " + String.valueOf(chiffre));

        }

    };
}
