package com.example.abiturientapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AboutVolgu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_volgu);
    }

    public void aboutToContactsInstitute(View v){
        Intent intent = new Intent(this, ContactsVolgu.class);
        startActivity(intent);
    }

    public void aboutToMainInstitute(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}