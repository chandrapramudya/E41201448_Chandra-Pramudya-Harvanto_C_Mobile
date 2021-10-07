package com.example.comictoon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailComicActivity extends AppCompatActivity {

    //Mendeklarasikan item yang ada pada activity_detail_comic.xml
    TextView textViewTitle, textViewRating, textViewReleaseDate, textViewGenre, textViewPenulis, textViewSinopsis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_comic);

        textViewTitle = findViewById(R.id.comicTitle);
        textViewRating = findViewById(R.id.comicRating);
        textViewReleaseDate = findViewById(R.id.comicReleaseDate);
        textViewGenre = findViewById(R.id.comicGenre);
        textViewPenulis = findViewById(R.id.comicPenulis);
        textViewSinopsis = findViewById(R.id.comicSinopsis);

        //Memanggil data intent dan menyimpan di objek comics
        Comics comics = getIntent().getParcelableExtra("COMICS");
        textViewTitle.setText(comics.getTitle());
        textViewRating.setText(String.valueOf(comics.getRating()));
        textViewReleaseDate.setText(comics.getReleasedate());
        textViewGenre.setText(comics.getGenre());
        textViewPenulis.setText(comics.getPenulis());
        textViewSinopsis.setText(comics.getSinopsis());
    }
}