package com.tugas.ayupriyambodo.ayupriyambodo_1202154303;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    private int hargaEatBus = 45000;
    private int hargaUbnormal = 60000;
    private int uang = 70000;
    private EditText aMenu;
    private EditText aTotal;
    private int totalHarga;
    String tersediaMenu = "Nasi Uduk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aMenu = (EditText) findViewById(R.id.menu);
        aTotal = (EditText) findViewById(R.id.jumlah);

    }

    public void clickUbnormal(View view) {
        Log.d(LOG_TAG, "Button Ubnormal");
        Context context = getApplicationContext();
        Toast noMenu = Toast.makeText(context, "Makanan Kosong!!!", Toast.LENGTH_LONG);
        Toast noTotal = Toast.makeText(context, "Stock Minim 2 lebih baik", Toast.LENGTH_LONG);
        int jumlah = Integer.parseInt(aTotal.getText().toString());
        String menu = aMenu.getText().toString();
        totalHarga = jumlah * hargaUbnormal;
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("jumlah", jumlah);
        intent.putExtra("menu", menu);
        intent.putExtra("totalHarga", totalHarga);
        intent.putExtra("uang", uang);
        intent.putExtra("lokasi", "Ubnormal");
        if (aMenu.getText().toString().equals("Nasi Uduk")){
            if (aTotal.getText().toString().equals("2")){
                startActivity(intent);
            } else {
                noTotal.show();
            }
        }

    }

    public void clickEatBus(View view) {
        Log.d(LOG_TAG, "Button EatBus");
        Context context = getApplicationContext();
        Toast noMenu = Toast.makeText(context, "Makanan Kosong Bre!!!", Toast.LENGTH_LONG);
        Toast noTotal = Toast.makeText(context, "Stock Minim 2 lebih baik", Toast.LENGTH_LONG);
        int jumlah = Integer.parseInt(aTotal.getText().toString());
        String menu = aMenu.getText().toString();
        totalHarga = jumlah * hargaEatBus;
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("jumlah", jumlah);
        intent.putExtra("menu", menu);
        intent.putExtra("totalHarga", totalHarga);
        intent.putExtra("uang", uang);
        intent.putExtra("lokasi", "EatBus");
        if (aMenu.getText().toString().equals("Nasi Uduk")) {
            startActivity(intent);
        } else {
            noTotal.show();
        }
      }
}
