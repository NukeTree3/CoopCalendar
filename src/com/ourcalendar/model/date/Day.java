package com.ourcalendar.model.date;

import java.io.Serializable;

public class Day implements Serializable {


    private int numberOfDay;
    private String dayOfWeek;
    private String comments;


    public void setNumberOfDay(int day){
        this.numberOfDay = day;
    }
    public int getNumberOfDay(){
        return numberOfDay;
    }
    public void setDayOfWeek(String day){
        this.dayOfWeek = day;
    }
    public String getDayOfWeek(){
        return dayOfWeek;
    }
    public void setComments(String text){
        this.comments = text;
    }
    public String getComments(){
        return comments;
    }
}
