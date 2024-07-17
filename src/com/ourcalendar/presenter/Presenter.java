package com.ourcalendar.presenter;

import com.ourcalendar.model.date.Year;
import com.ourcalendar.model.user.CommentsEditor;
import com.ourcalendar.model.user.UserChanges;
import com.ourcalendar.model.user.UserComments;

import java.util.ArrayList;

public class Presenter {

    private UserComments userComments = new UserComments();
    private UserChanges userChanges = new UserChanges();

    public void addComment(int day, int month, Year year, String comment){

        CommentsEditor commentsEditor = new CommentsEditor();

        commentsEditor.addComments(day,month,year,comment);

        userChanges.setUserChanges(userComments.addTextPlusDay(year.getMonth(month-1).getDay(day-1),month,year.GetYear()));
    }

    public ArrayList<String> getUserChanges(){
        return userChanges.getUserChanges();
    }
}