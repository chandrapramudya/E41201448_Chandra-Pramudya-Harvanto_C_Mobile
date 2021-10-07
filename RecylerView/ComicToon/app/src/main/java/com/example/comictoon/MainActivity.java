package com.example.comictoon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Deklarasi recyclerview, adapter dan membuat arraylist dari Comics
    RecyclerView recyclerView;
    ComicsRecyclerViewAdapter adapter;
    ArrayList<Comics> objComics = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mencari recyclerview by id
        recyclerView = findViewById(R.id.recyclerView);

        //Data yang diisikan dalam arraylist
        objComics.add(new Comics("Si Ocong", "Komedi", "Agung Gunawan", 9.75, "Si Ocong adalah sosok yang songong nyebelin tapi ngangenin", "4 Oktober 2016"));
        objComics.add(new Comics("Dracko Diary", "Slice of life", "Indra AD", 9.71, "Dracko kini pergi merantau demi mengejar cita-citanya menjadi seorang animator", "11 Juli 2016"));
        objComics.add(new Comics("The God of High School", "Aksi", "Yongje Park", 9.77, "Turnamen untuk mencari anak SMA paling tangguh!", "24 November 2015"));

        //Menerapkan Adapter
        adapter = new ComicsRecyclerViewAdapter(objComics);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}