package com.ourcalendar.model.date;

import java.io.Serializable;

public class Month implements Serializable {
    private String nameOfMonth;
    private int numberOfMonth;
    private int lenthOfMonth = 31;

    public void setLenthOfMonth(int len){
        this.lenthOfMonth = len;
    }
    public int getlenthOfMonth(){
        return lenthOfMonth;
    }

    private Day[] days = new Day[lenthOfMonth];

    public void setNameOfMonth(String name){
        this.nameOfMonth = name;
    }
    public void setNumberOfMonth(int numberOfMonth){
        this.numberOfMonth = numberOfMonth;
    }
    public int getMonth(){
        return numberOfMonth;
    }
    public String getNameOfMonth(){
        return nameOfMonth;
    }
    public void setDays(Day[] days){
        this.days = days.clone();
    }
    public Day[] getDays(){
        return days;
    }
    public Day getDay(int numberOfDay){
        return days[numberOfDay];
    }
}
