package com.example.bosproje;
import static android.widget.CompoundButton.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class yemeksorgu extends AppCompatActivity {

    CheckBox yumurtaedit, yagedit, domatesedit, soganedit, biberedit, tuzedit, makarnaedit;  //ölü
    public void butonanasayfa(View view){
        Intent anasayfaa = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(anasayfaa);
    }

    //oncreate yani ilk açıldığında gerçekleşecek olayları barındırıyor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemeksorgu);

        CheckBox checkBox = findViewById(R.id.yumurta);
        CheckBox checkBox2 = findViewById(R.id.yag);
        CheckBox checkBox3 = findViewById(R.id.domates);
        CheckBox checkBox4 = findViewById(R.id.sogan);
        CheckBox checkBox5 = findViewById(R.id.biber);
        CheckBox checkBox6 = findViewById(R.id.tuz);
        CheckBox checkBox7 = findViewById(R.id.makarna);
        CheckBox checkBox8 = findViewById(R.id.peynir);
        CheckBox checkBox9 = findViewById(R.id.tavuk);
        CheckBox checkBox10 = findViewById(R.id.patates);
        CheckBox checkBox11 = findViewById(R.id.mantar);
        CheckBox checkBox12 = findViewById(R.id.kiyma);


        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override // else if yapınca çok seçenekli olunca patlıyor
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked() && checkBox2.isChecked() && checkBox6.isChecked()) {
                    Intent yumurtayayolluyor = new Intent(getApplicationContext(), yumurtahazir.class);
                    Toast.makeText(yemeksorgu.this, "Uygun Yemek Bulundu", Toast.LENGTH_SHORT).show();
                    startActivity(yumurtayayolluyor);
                }
                if (checkBox7.isChecked() && checkBox6.isChecked())  {
                    Intent makarnahazir = new Intent(getApplicationContext(), makarnahazir.class);
                    Toast.makeText(yemeksorgu.this, "Uygun Yemek Bulundu", Toast.LENGTH_SHORT).show();
                    startActivity(makarnahazir);
                }
                if (checkBox.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked() && checkBox6.isChecked()) {
                    Intent menemenhazir = new Intent(getApplicationContext(), menemenhazir.class);
                    Toast.makeText(yemeksorgu.this, "Uygun Yemek Bulundu", Toast.LENGTH_SHORT).show();
                    startActivity(menemenhazir);
                }
                if (checkBox7.isChecked() && checkBox9.isChecked() && checkBox6.isChecked()) {
                    Intent tavuklumakarna = new Intent(getApplicationContext(), tavuklumakarna.class);
                    Toast.makeText(yemeksorgu.this, "Uygun Yemek Bulundu", Toast.LENGTH_SHORT).show();
                    startActivity(tavuklumakarna);
                }
                if (checkBox10.isChecked() && checkBox2.isChecked() && checkBox.isChecked()) {
                    Intent patatesliyumur = new Intent(getApplicationContext(), patatesliyumur.class);
                    Toast.makeText(yemeksorgu.this, "Uygun Yemek Bulundu", Toast.LENGTH_SHORT).show();
                    startActivity(patatesliyumur);
                }
                if (checkBox12.isChecked() && checkBox6.isChecked()) {
                    Intent kebap = new Intent(getApplicationContext(), kebap.class);
                    Toast.makeText(yemeksorgu.this, "Uygun Yemek Bulundu", Toast.LENGTH_SHORT).show();
                    startActivity(kebap);
                }else {
                    Toast.makeText(yemeksorgu.this, "Uygun Yemek Bulunamadi", Toast.LENGTH_SHORT).show();
                }
            }});


    }
}
