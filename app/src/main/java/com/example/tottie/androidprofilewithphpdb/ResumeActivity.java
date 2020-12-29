package com.example.tottie.androidprofilewithphpdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ResumeActivity extends AppCompatActivity {

    PDFView myResume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        loadMyResume();
    }

    public void loadMyResume(){
        myResume = findViewById(R.id.myResume);
        myResume.fromAsset("myNewResume.pdf").load();
    }

}
