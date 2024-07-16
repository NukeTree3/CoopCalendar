package com.ourcalendar.model.service;

import com.ourcalendar.model.date.CreateYear;
import com.ourcalendar.model.date.Year;
import com.ourcalendar.model.user.CommentsEditor;
import com.ourcalendar.model.user.UserComments;
import com.ourcalendar.view.Table;

public class Service {

    public Year createYear(int year){
        CreateYear createYear = new CreateYear();
        return createYear.CreateYear(year);
    }

    public void outputTable(Year year){
        Table table = new Table();
        table.CreateTable(year);
    }

    public void addComment(int day, int month, Year year, String comment){
        CommentsEditor commentsEditor = new CommentsEditor();
        UserComments userComments = new UserComments();
        commentsEditor.addComments(day, month, year, comment);
        userComments.addTextPlusDay(year.getMonth(month-1).getDay(day-1), month, year.GetYear());
    }
}
