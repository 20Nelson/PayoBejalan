package com.nelsen.payobejalan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fabTambah;
    private RecyclerView rvDestinasi;
    private MyDatabaseHelper myDB;
    private ArrayList<String> arrId, arrNama, arrAlamat, arrJam;
    private AdapterDestinasi adDestinasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabTambah = findViewById(R.id.fab_tambah);
        rvDestinasi = findViewById(R.id.rv_destinasi);

        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
    }

    private void SQLiteToArrayList(){
        Cursor varCursor = myDB.bacaDataDestinasi();
        if(varCursor.getCount() == 0){
            Toast.makeText(this, "Tidak Tidak Tersedia", Toast.LENGTH_SHORT).show();
        }
        else{
            while (varCursor.moveToNext()){
                arrId.add(varCursor.getString(0));
                arrNama.add(varCursor.getString(1));
                arrAlamat.add(varCursor.getString(2));
                arrJam.add(varCursor.getString(3));
            }
        }
    }

    private void tampilDestinasi(){
        arrId = new ArrayList<>();
        arrNama = new ArrayList<>();
        arrAlamat = new ArrayList<>();
        arrJam = new ArrayList<>();

        SQLiteToArrayList();

        rvDestinasi = findViewById(R.id.rv_destinasi);
        adDestinasi = new AdapterDestinasi(MainActivity.this, arrId, arrNama, arrAlamat, arrJam);

        rvDestinasi.setAdapter(adDestinasi);
        rvDestinasi.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        tampilDestinasi();
    }
}