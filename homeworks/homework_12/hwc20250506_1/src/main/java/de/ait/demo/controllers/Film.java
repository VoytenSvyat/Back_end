package de.ait.demo.controllers;

public class Film {
    String name;
    String genre;
    int year;

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public Film(){};
    public Film(String name, String genre, int year) {
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                '}';
    }
}
