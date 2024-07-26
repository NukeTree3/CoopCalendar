package com.ourcalendar.model.table;

import com.ourcalendar.model.user.accepteddata.AcceptedData;
import com.ourcalendar.model.user.accepteddata.DayAccepted;
import com.ourcalendar.model.date.Day;
import com.ourcalendar.model.date.Month;
import com.ourcalendar.model.date.Year;

import java.time.DayOfWeek;

public class Table {
    public String createTable(Year year1, AcceptedData acceptedData){
        StringBuilder stringBuilder = new StringBuilder();
        for (Month moth :year1.getMonths()){
            stringBuilder.append(moth.getNameOfMonth());
            stringBuilder.append("\n");
            int count = 0;
            stringBuilder.append("MON_TUE_WED_THU_FRI_SAT_SUN");
            stringBuilder.append("\n");

            for (Day day : moth.getDays()){
                count++;
                DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.getDayOfWeek());
                int a = 0;
                while (dayOfWeek.getValue()-a!=1 && day.getNumberOfDay()==1){
                    stringBuilder.append("---");
                    a++;
                    count++;
                }
                stringBuilder.append(day.getNumberOfDay());
                stringBuilder.append("/");
                if (day.getComments()!=null){
                    stringBuilder.append(day.getComments());
                }
                for (DayAccepted dayAccepted: acceptedData.getData()) {
                    if (year1.getYear() == dayAccepted.getYear() && moth.getMonth() == dayAccepted.getMonth() && day.getNumberOfDay() == dayAccepted.getDay()){
                        stringBuilder.append(" от других пользователей ");
                        stringBuilder.append(dayAccepted.getMessage());
                    }
                }
                if (count>=7){
                    stringBuilder.append("\n");
                    count = 0;
                }
                stringBuilder.append("_");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
