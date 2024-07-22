package com.ourcalendar.model.date;

import java.io.Serializable;
import java.util.ArrayList;

public class TimeLine implements Serializable {
    private ArrayList<Year> timeLine = new ArrayList<>();

    public void addYear(Year year){
        timeLine.add(year);
    }

    public ArrayList<Year> getTimeLine(){
        return timeLine;
    }
}
