package com.example.abiturientapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class ImitKafedra extends AppCompatActivity {


    ConstraintLayout imit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imit_kafedra);


        Button mos = findViewById(R.id.buttonMos);
        Button pmi = findViewById(R.id.buttonPmi);
        Button pi = findViewById(R.id.buttonPi);
        Button ivt = findViewById(R.id.buttonIvt);
        Button ist = findViewById(R.id.buttonIst);
        Button pri = findViewById(R.id.buttonPri);
        Button pmif = findViewById(R.id.buttonPmif);
        Button radioFiz = findViewById(R.id.buttonRadiofiz);
        Button radioTech = findViewById(R.id.buttonRadiotech);

        imit = findViewById(R.id.imit);


        Button mkn = findViewById(R.id.buttonMkn);
        mkn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInputScores();
            }
        });


    }

    private void openInputScores() {

        AlertDialog.Builder dial = new AlertDialog.Builder(this);
        dial.setTitle("Ввод баллов");
        dial.setMessage("Введите сумму баллов по тем предметам, которые необходимы для поступления на данную кафедру");

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View inputScores = layoutInflater.inflate(R.layout.input_scores, null);
        dial.setView(inputScores);

        EditText scores = findViewById(R.id.scores);

        dial.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dial.setPositiveButton("Ввод", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(scores.getText().toString())){
                    Snackbar.make(imit, "Введите ваши баллы", Snackbar.LENGTH_LONG).show();
                    return;
                }
                String scoresValue = scores.getText().toString();
                if(Integer.parseInt(scoresValue) > 300){
                    Snackbar.make(imit,"Сумма баллов не может превышать 300" , Snackbar.LENGTH_SHORT).show();
                    return;
                }


            }
        });

    dial.show();
    }
}