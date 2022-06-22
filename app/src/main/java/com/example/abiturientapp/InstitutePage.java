package com.example.abiturientapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InstitutePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_page);

        ConstraintLayout instituteInfoBg = findViewById(R.id.institutePageBg);
        TextView instituteInfoTittle = findViewById(R.id.instituteInfoTittle);
        TextView instituteInfoText = findViewById(R.id.instituteInfoText);

        instituteInfoBg.setBackgroundColor(getIntent().getIntExtra("instituteBg", 0));
        instituteInfoTittle.setText(getIntent().getStringExtra("instituteTittle"));
        instituteInfoText.setText(getIntent().getStringExtra("instituteText"));
    }
}