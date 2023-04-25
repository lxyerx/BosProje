package com.example.bosproje;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class kayitekran extends AppCompatActivity {
    private EditText adtext, soyadtext;
    private Button BtnKayitOl;
    private DatabaseReference databaseReference;

    public void anasayfa11(View view){ // anasayfaya yolluyor
        // intent oluşturduk sonuna ise gideceğimiz yeri yazdık
        Intent anasayfa = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(anasayfa);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitekran);

        databaseReference = FirebaseDatabase.getInstance().getReference("Kullanicilar");

        // EditText ve buton nesnelerinin atamaları yapılıyor
        adtext = findViewById(R.id.adtext);
        soyadtext = findViewById(R.id.soyadtext);
        BtnKayitOl = findViewById(R.id.BtnKayitOl);

        BtnKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kullaniciekle();
            }
        });
    }

    private void kullaniciekle() {
        String isim = adtext.getText().toString();
        String soyad = soyadtext.getText().toString();

        if (TextUtils.isEmpty(isim) || TextUtils.isEmpty(soyad)) {
            Toast.makeText(this, "Lütfen ad ve soyad giriniz.", Toast.LENGTH_SHORT).show();
            return;
        }

        String id = databaseReference.push().getKey();
        insan insan = new insan(id, isim, soyad);

        databaseReference.child(id).setValue(insan, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                if (error != null) {
                    Toast.makeText(kayitekran.this, "Kayıt başarısız oldu. Lütfen tekrar deneyiniz.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(kayitekran.this, "Kayıt başarılı bir şekilde tamamlandı.", Toast.LENGTH_SHORT).show();
                    Intent anasayfa = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(anasayfa);
                }
            }
        });
    }

    }

