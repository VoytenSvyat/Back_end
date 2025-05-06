package de.ait.demo.controllers;

public class Book {
    String name;
    String author;
    int year;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public Book(){};
    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
