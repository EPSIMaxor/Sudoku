package com.sudoku.maxor.sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelActivity extends AppCompatActivity {
    private Button btnlvl1;
    private Button btnlvl2;
    private Button btnlvl3;
    private Intent i;
    private Bundle lvlbundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        btnlvl1 = this.findViewById(R.id.btnLvl1);
        btnlvl2 = this.findViewById(R.id.btnLvl2);
        btnlvl1.setOnClickListener(btnclick);
        btnlvl2.setOnClickListener(btnclick);
        i = new Intent(getApplicationContext(), GetGrilleActivity.class);
    }

    private View.OnClickListener btnclick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnLvl1:
                    lvlbundle.putInt("lvlinfo", 1);
                    i.putExtras(lvlbundle);
                    startActivity(i);
                    break;
                case R.id.btnLvl2:
                    lvlbundle.putInt("lvlinfo", 2);
                    i.putExtras(lvlbundle);
                    startActivity(i);
                    break;
            }
        }
    };
}
