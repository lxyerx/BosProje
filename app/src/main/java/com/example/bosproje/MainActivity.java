package com.example.bosproje;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void gonder(View view){ // kayitEkrani Sekmesine gitmeyi sagliyor

        Intent kayitekran = new Intent(getApplicationContext(),kayitekran.class);
        startActivity(kayitekran);
    }

    public void girisyap(View view){ // anasayfaya yolluyor
        // intent oluşturduk sonuna ise gideceğimiz yeri yazdık
        Intent GirisEkran = new Intent(getApplicationContext(),GirisEkran.class);
        startActivity(GirisEkran);
    }

    public void girisyapmadandevam(View view){ // anasayfaya yolluyor
        // intent oluşturduk sonuna ise gideceğimiz yeri yazdık
        Intent yemeksorgusayfa = new Intent(getApplicationContext(),yemeksorgu.class);
        startActivity(yemeksorgusayfa);
    }



}