package com.ourcalendar.model.date;

import java.io.Serializable;

public class Year implements Serializable {
    private int year;
    private Month[] months = new Month[12];

    public void SetYear(int year){
        this.year = year;
    }
    public int GetYear(){
        return year;
    }
    public void SetMonths(Month[] months){
        this.months = months.clone();
    }
    public Month[] GetMonths(){
        return months;
    }
    public Month getMonth(int numderOfMonth){
        return months[numderOfMonth];
    }
}
