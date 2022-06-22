package com.example.abiturientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

public class ContactsVolgu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_volgu);


    }

    public void aboutInstitute(View v){
        Intent intent = new Intent(this, AboutVolgu.class);
        startActivity(intent);
    }

    public void mainInstitute(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}