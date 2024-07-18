package com.ourcalendar.model.user.accepteddata;

public class DayAccepted {
    int day;
    int month;
    int year;
    String message;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getMessage() {
        return message;
    }

    public void setDay(int day){
        this.day = day;
    }

    public void setMonth(int month){
        this.month = month;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
