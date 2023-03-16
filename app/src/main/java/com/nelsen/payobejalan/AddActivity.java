package com.nelsen.payobejalan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    private EditText etNama, etAlamat, etJam;
    private Button btnTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etNama = findViewById(R.id.et_nama);
        etAlamat = findViewById(R.id.et_alamat);
        etJam = findViewById(R.id.et_jam);
        btnTambah = findViewById(R.id.btn_tambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama, alamat, jam;

                nama = etNama.getText().toString();
                alamat = etAlamat.getText().toString();
                jam = etJam.getText().toString();

                if(nama.trim().equals("")){
                    etNama.setError("Nama Tidak Boleh Kosong");
                } else if (alamat.trim().equals("")) {
                    etAlamat.setError("Alamat Tidak Boleh Kosong");
                } else if (jam.trim().equals("")) {
                    etJam.setError("Jam Tidak Boleh Kosong");
                }else{
                    
                }
            }
        });
    }
}