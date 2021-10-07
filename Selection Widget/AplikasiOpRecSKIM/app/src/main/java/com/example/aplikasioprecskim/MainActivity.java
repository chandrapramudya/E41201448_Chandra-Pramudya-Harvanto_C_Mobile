package com.example.aplikasioprecskim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Mendeklarasikan spinner, listview dan autocompleteTextview
    Spinner spinner;
    AutoCompleteTextView autocompletetext;
    ListView listviewdivisi;
    //Membuat list array untuk daftar prodi yang digunakan dalam autocompleteTextview
    private static final String[] prodi = new String[]{
            "Produksi Tanaman Hortikultura", "Produksi Tanaman Perkebunan", "Teknik Produksi Benih",
            "Teknologi Produksi Tanaman Pangan", "Budidaya Tanaman Perkebunan", "Pengelolaan Perkebunan Kopi",
            "Keteknikan Pertanian", "Teknologi Industri Pangan", "Teknologi Rekayasa Pangan","Produksi Ternak",
            "Manajemen Bisnis Unggas", "Manajemen Agribisnis", "Manajemen Agroindustri", "Akutansi Sektor Publik",
            "Manajemen Informatika", "Teknik Komputer", "Teknik Informatika", "Bahasa Inggris", "Rekam Medik",
            "Gizi Klinik", "Teknik Energi Terbarukan", "Mesin Otomotif", "Teknologi Rekayasa Mekatronika",
            "Manajemen Informatika (INT)", "Teknik Informatika (INT)", "Manajemen Agroindustri (INT)"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi spinner
        spinner = findViewById(R.id.spinner);

        //fungsi untuk menampilkan list data ke spinner menggunakan adapter
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this, R.array.jurusan, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Action Click
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String fakultas = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Dipilih : "+fakultas, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Inisialisasi autocompleteTextview
        AutoCompleteTextView autocompletetext = findViewById(R.id.actv);
        //fungsi untuk menampilkan list data dari array yang sudah dibuat menggunakan adapter
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, prodi);
        autocompletetext.setAdapter(adapter1);

        //Action Click
        autocompletetext.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String getprodi = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Prodi yang dipilih : "+getprodi, Toast.LENGTH_SHORT).show();
            }
        });

        //Inisialisasi Array
        listviewdivisi = findViewById(R.id.listviewdivisi);
        String[] divisi = {"Karya Tulis Ilmiah", "Bussiness Plan", "Essay", "Puisi"};

        //fungsi untuk menampilkan list data ke listview menggunakan adapter
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, divisi);
        listviewdivisi.setAdapter(adapter2);

        //Action Click
        listviewdivisi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String getdivisi = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Memilih : Divisi "+getdivisi, Toast.LENGTH_SHORT).show();
            }
        });
    }
}