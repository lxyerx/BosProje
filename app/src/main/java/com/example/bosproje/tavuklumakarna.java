package com.example.bosproje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class tavuklumakarna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tavuklumakarnahazir);
    }

    public void anasayfa10(View view){ // anasayfaya yolluyor
        // intent oluşturduk sonuna ise gideceğimiz yeri yazdık
        Intent anasayfa = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(anasayfa);
    }
}