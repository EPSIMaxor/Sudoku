package com.sudoku.maxor.sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Starter extends AppCompatActivity {
    private Button btnC;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
        Button btn = this.findViewById(R.id.btnC);
        btn.setOnClickListener(btnclick);
    }

    private View.OnClickListener btnclick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);

        }
    };
}
