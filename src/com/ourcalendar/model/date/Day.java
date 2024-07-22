package com.ourcalendar.model.date;

import java.io.Serializable;

public class Day implements Serializable {


    private int numberOfDay;
    private String dayOfWeek;
    private String comments;


    public void SetNumberOfDay(int day){
        this.numberOfDay = day;
    }
    public int GetNumberOfDay(){
        return numberOfDay;
    }
    public void SetDayOfWeek(String day){
        this.dayOfWeek = day;
    }
    public String GetDayOfWeek(){
        return dayOfWeek;
    }
    public void SetComments(String text){
        this.comments = text;
    }
    public String GetComments(){
        return comments;
    }
}
