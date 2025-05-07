package de.ait.demo.controllers;

import lombok.Builder;

import java.time.LocalDateTime;

// @Builder
public class Time {
    /* через builder
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
     */
    private final LocalDateTime dateTime;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Time(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Time{" +
                "dateTime=" + dateTime +
                '}';
    }
}
