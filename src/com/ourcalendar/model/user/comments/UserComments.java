package com.ourcalendar.model.user.comments;

import com.ourcalendar.model.date.Day;

public class UserComments {

    public String addTextPlusDay(Day day, int NumberOfMonth, int year) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(day.GetNumberOfDay());
        stringBuilder.append("##!!##");
        stringBuilder.append(NumberOfMonth);
        stringBuilder.append("##!!##");
        stringBuilder.append(year);
        stringBuilder.append("##!!##");
        stringBuilder.append(day.GetComments());
        return stringBuilder.toString();
    }
}