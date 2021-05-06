package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PatientMainA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_main);
    }
     /* 각 버튼을 누르면 화면을 이동시킬 인텐트 입니다.
    public void go1(View view) {
        Intent intent = new Intent(this, .class);
        startActivity(intent);
        finish();
    }
    public void go2(View view) {
        Intent intent = new Intent(this, .class);
        startActivity(intent);
        finish();
    }*/
}