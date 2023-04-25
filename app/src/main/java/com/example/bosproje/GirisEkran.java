package com.example.bosproje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

public class GirisEkran extends AppCompatActivity {

    private EditText adtext, soyadtext;
    private Button girisButton;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekran);

        adtext = findViewById(R.id.giris_yap_ad);
        soyadtext = findViewById(R.id.giris_yap_soyad);
        girisButton = findViewById(R.id.GirisYap);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Kullanicilar");

        girisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ad = adtext.getText().toString().trim();
                final String soyad = soyadtext.getText().toString().trim();

                Query query = mDatabase.orderByChild("ad").equalTo(ad);

                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        boolean isExist = false;
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            insan kullanici = dataSnapshot.getValue(insan.class);
                            if (kullanici.getSoyad().equals(soyad)) {
                                isExist = true;
                                break;
                            }
                        }

                        if (isExist) {
                            Toast.makeText(GirisEkran.this, "Giris Basarili", Toast.LENGTH_SHORT).show();
                            Intent main = new Intent(GirisEkran.this, yemeksorgu.class);
                            startActivity(main);
                            finish();
                        } else {
                            Toast.makeText(GirisEkran.this, "Kullanici bulunamadi", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(GirisEkran.this, "Database hatasi", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}

