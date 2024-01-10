package com.example.inputusia; // Replace with your actual package name

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNama;
    private EditText editTextUmur;
    private EditText editTextProfesi;
    private EditText editTextHobi;
    private Button buttonProses;
    private TextView textViewStatus;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNama = findViewById(R.id.editTextNama);
        editTextUmur = findViewById(R.id.editTextUmur);
        editTextProfesi = findViewById(R.id.editTextProfesi);
        editTextHobi = findViewById(R.id.editTextHobi);
        buttonProses = findViewById(R.id.buttonProses);
        textViewStatus = findViewById(R.id.textViewStatus);

        buttonProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prosesData();
            }
        });
    }

    private void prosesData() {
        String nama = editTextNama.getText().toString();
        String umurStr = editTextUmur.getText().toString();
        String profesi = editTextProfesi.getText().toString();
        String hobi = editTextHobi.getText().toString();

        if (!nama.isEmpty() && !umurStr.isEmpty() && !profesi.isEmpty() && !hobi.isEmpty()) {
            int umur = Integer.parseInt(umurStr);

            // Proses untuk menentukan status
            String status;
            if (umur < 10) {
                status = "Anak-anak";
            } else if (umur < 20) {
                status = "Remaja";
            } else if (umur < 40) {
                status = "Dewasa";
            } else {
                status = "Tua";
            }

            // Tampilkan hasil status
            textViewStatus.setText("Nama: " + nama + "\nUmur: " + umur +
                    "\nProfesi: " + profesi + "\nHobi: " + hobi +
                    "\nStatus: " + status);
        } else {
            // Jika input kosong
            textViewStatus.setText("Masukkan semua data terlebih dahulu!");
        }
    }
}
