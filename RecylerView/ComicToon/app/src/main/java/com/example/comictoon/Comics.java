package com.example.comictoon;

import android.os.Parcel;
import android.os.Parcelable;
//Membuat Data POJO(Plain Old Java Object)
public class Comics implements Parcelable {
    private String title;
    private String genre;
    private String penulis;
    private double rating;
    private String sinopsis;
    private String releasedate;
//Constructor
    public Comics(String title, String genre, String penulis, double rating, String sinopsis, String releasedate) {
        this.title = title;
        this.genre = genre;
        this.penulis = penulis;
        this.rating = rating;
        this.sinopsis = sinopsis;
        this.releasedate = releasedate;
    }
//Getter dan Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }
//class parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.genre);
        dest.writeString(this.penulis);
        dest.writeDouble(this.rating);
        dest.writeString(this.sinopsis);
        dest.writeString(this.releasedate);
    }

    public void readFromParcel(Parcel source) {
        this.title = source.readString();
        this.genre = source.readString();
        this.penulis = source.readString();
        this.rating = source.readDouble();
        this.sinopsis = source.readString();
        this.releasedate = source.readString();
    }

    protected Comics(Parcel in) {
        this.title = in.readString();
        this.genre = in.readString();
        this.penulis = in.readString();
        this.rating = in.readDouble();
        this.sinopsis = in.readString();
        this.releasedate = in.readString();
    }

    public static final Creator<Comics> CREATOR = new Creator<Comics>() {
        @Override
        public Comics createFromParcel(Parcel source) {
            return new Comics(source);
        }

        @Override
        public Comics[] newArray(int size) {
            return new Comics[size];
        }
    };
}
