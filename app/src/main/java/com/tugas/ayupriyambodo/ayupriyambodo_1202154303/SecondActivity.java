package com.tugas.ayupriyambodo.ayupriyambodo_1202154303;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Context context = getApplicationContext();

        Toast ya = Toast.makeText(context, "sung bre", Toast.LENGTH_LONG);
        Toast engga = Toast.makeText(context, "Duitnya engga susai dompet", Toast.LENGTH_LONG);
        TextView menuView = (TextView) findViewById(R.id.hasilMenu);
        TextView hargaView = (TextView) findViewById(R.id.hasilHarga);
        TextView jumlahView = (TextView) findViewById(R.id.hasilPorsi);
        TextView tempatView = (TextView) findViewById(R.id.hasilTempat);

        Intent intent = getIntent();
        int totalInt = intent.getIntExtra("totalHarga", 0);
        String total = Integer.toString(totalInt);
        int jumlahInt = intent.getIntExtra("jumlah", 0);
        String porsi = Integer.toString(jumlahInt);
        String menu = String.valueOf(Integer.getInteger("menu"));
        int uangInt = intent.getIntExtra("uang", 0);
        String lokasi = String.valueOf(Integer.getInteger("lokasi"));

        menuView.setText(menu);
        hargaView.setText(total);
        jumlahView.setText(lokasi);

        if (uangInt <= totalInt){
            engga.show();
            tempatView.setRawInputType(Integer.parseInt(lokasi));
        } else {
            ya.show();
            tempatView.setRawInputType(Integer.parseInt(lokasi));
        }
    }
}
