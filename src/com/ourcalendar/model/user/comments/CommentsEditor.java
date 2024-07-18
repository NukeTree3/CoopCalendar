package com.ourcalendar.model.user.comments;

import com.ourcalendar.model.date.Year;

public class CommentsEditor {
    public void addComments(int day, int month, Year year, String comment){
        year.getMonth(month-1).getDay(day-1).SetComments(comment);
    }
}
