package com.example.comictoon;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
//Inisialisasi adapter dan membuat inner class
public class ComicsRecyclerViewAdapter extends RecyclerView.Adapter<ComicsRecyclerViewAdapter.ComicViewHolder> {
    ArrayList<Comics> arrayListComics;
//Constructor
    public ComicsRecyclerViewAdapter(ArrayList<Comics> arrayListComics) {
        this.arrayListComics = arrayListComics;
    }
//Method
    @NonNull
    @Override
    public ComicsRecyclerViewAdapter.ComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicsRecyclerViewAdapter.ComicViewHolder holder, int position) {
        final Comics comics = arrayListComics.get(position);
        //Set text nilai yang tersimpan dalan arraylist
        holder.textViewTitle.setText(comics.getTitle());
        holder.textViewRating.setText(String.valueOf(comics.getRating()));
        holder.textViewReleaseDate.setText(comics.getReleasedate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailComicActivity.class);
                intent.putExtra("COMICS", comics);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListComics.size();
    }

    public class ComicViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewRating, textViewReleaseDate;
        public ComicViewHolder(@NonNull View itemView) {
            super(itemView);
            //mendeklarasikan item title,rating dan releasedate
            textViewTitle = itemView.findViewById(R.id.comicTitle);
            textViewRating = itemView.findViewById(R.id.comicRating);
            textViewReleaseDate = itemView.findViewById(R.id.comicReleaseDate);
        }
    }
}
