package com.sudoku.maxor.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int chiffre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chiffre = 0;
        Bundle bl = this.getIntent().getExtras();
        String res = bl.getString("resGrille");

    }


    private View.OnClickListener btnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }

    };
}
