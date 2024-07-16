package com.ourcalendar.model.user;

import com.ourcalendar.model.date.Day;

import java.util.ArrayList;

public class UserComments {
    private ArrayList comments = new ArrayList<>();
    public void addTextPlusDay(Day day, int NumberOfMonth, int year){
        ArrayList textPlusDay = new ArrayList();
        textPlusDay.add(day);
        textPlusDay.add(NumberOfMonth);
        textPlusDay.add(year);
        comments.add(textPlusDay);
    }
}
