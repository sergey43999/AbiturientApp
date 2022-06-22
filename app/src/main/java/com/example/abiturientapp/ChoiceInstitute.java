package com.example.abiturientapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoiceInstitute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_institute);


        Button imit = findViewById(R.id.buttonImit);
        imit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceInstitute.this, ImitKafedra.class);
                startActivity(intent);
            }
        });
        Button ien = findViewById(R.id.buttonIen);
        ien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceInstitute.this, IenKafedra.class);
                startActivity(intent);
            }
            });
        Button iimost = findViewById(R.id.buttonIimost);
        iimost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceInstitute.this, IimostKafedra.class);
                startActivity(intent);
            }
        });
        Button ip = findViewById(R.id.buttonIp);
        ip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceInstitute.this, IpKafedra.class);
                startActivity(intent);
            }
        });
        Button ipt = findViewById(R.id.buttonIpt);
        ipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceInstitute.this, IptKafedra.class);
                startActivity(intent);
            }
        });
        Button iu = findViewById(R.id.buttonIu);
        iu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceInstitute.this, IuKafedra.class);
                startActivity(intent);
            }
        });
        Button ifimkk = findViewById(R.id.buttonIfimkk);
        ifimkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceInstitute.this, IfimkkKafedra.class);
                startActivity(intent);
            }
        });
        Button imo = findViewById(R.id.buttonImo);
        imo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoiceInstitute.this, ImoKafedra.class);
                startActivity(intent);
            }
        });



    }
}