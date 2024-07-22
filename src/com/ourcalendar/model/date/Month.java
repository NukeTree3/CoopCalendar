package com.ourcalendar.model.date;

import java.io.Serializable;

public class Month implements Serializable {
    private String nameOfMonth;
    private int numberOfMonth;
    private int lenthOfMonth = 31;

    public void SetLenthOfMonth(int len){
        this.lenthOfMonth = len;
    }
    public int GetlenthOfMonth(){
        return lenthOfMonth;
    }

    private Day[] days = new Day[lenthOfMonth];

    public void SetNameOfMonth(String name){
        this.nameOfMonth = name;
    }
    public void setNumberOfMonth(int numberOfMonth){
        this.numberOfMonth = numberOfMonth;
    }
    public int getMonth(){
        return numberOfMonth;
    }
    public String GetNameOfMonth(){
        return nameOfMonth;
    }
    public void SetDays(Day[] days){
        this.days = days.clone();
    }
    public Day[] GetDays(){
        return days;
    }
    public Day getDay(int numberOfDay){
        return days[numberOfDay];
    }
}
