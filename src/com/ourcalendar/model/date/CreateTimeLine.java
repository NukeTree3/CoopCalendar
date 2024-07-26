package com.ourcalendar.model.date;

import java.time.LocalDate;

public class CreateTimeLine {

    public void createTimeLine(TimeLine timeLine){
        for(int i = 2020; i<2050; i++){
            timeLine.addYear(createYear(i));
        }
    }

    public Year createYear(int year){
        Year creatyear = new Year();
        creatyear.setYear(year);
        LocalDate day;
        Month[] months = new Month[12];
        for (int i = 1; i<=12; i++){
            day = LocalDate.of(year,i,1);
            Month month = new Month();
            month.setNameOfMonth(day.getMonth().toString());
            month.setNumberOfMonth(i);
            month.setLenthOfMonth(day.lengthOfMonth());
            Day[] days = new Day[day.lengthOfMonth()];
            for (int j = 1; j<=day.lengthOfMonth();j++){
                Day day1 = new Day();
                day = LocalDate.of(year,i,j);
                day1.setNumberOfDay(day.getDayOfMonth());
                day1.setDayOfWeek(day.getDayOfWeek().toString());
                days[j-1]=day1;
            }
            month.setDays(days);
            months[i-1]=month;
        }
        creatyear.SetMonths(months);
        return creatyear;
    }
}
