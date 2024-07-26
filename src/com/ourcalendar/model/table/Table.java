package com.ourcalendar.model.table;

import com.ourcalendar.model.user.accepteddata.AcceptedData;
import com.ourcalendar.model.user.accepteddata.DayAccepted;
import com.ourcalendar.model.date.Day;
import com.ourcalendar.model.date.Month;
import com.ourcalendar.model.date.Year;

import java.time.DayOfWeek;

public class Table {
    public String CreateTable(Year year1, AcceptedData acceptedData){
        StringBuilder stringBuilder = new StringBuilder();
        for (Month moth :year1.GetMonths()){
            stringBuilder.append(moth.GetNameOfMonth());
            //System.out.println(moth.GetNameOfMonth());
            stringBuilder.append("\n");
            int count = 0;
            stringBuilder.append("MON_TUE_WED_THU_FRI_SAT_SUN");
            //System.out.println("MON_TUE_WED_THU_FRI_SAT_SUN");
            stringBuilder.append("\n");

            for (Day day : moth.GetDays()){
                count++;
                DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.GetDayOfWeek());
                int a = 0;
                while (dayOfWeek.getValue()-a!=1 && day.GetNumberOfDay()==1){
                    stringBuilder.append("---");
                    //System.out.print("---");
                    a++;
                    count++;
                }
                stringBuilder.append(day.GetNumberOfDay());
                //System.out.print(day.GetNumberOfDay());
                stringBuilder.append("/");
                //System.out.print("/");
                if (day.GetComments()!=null){
                    stringBuilder.append(day.GetComments());
                    //System.out.print(day.GetComments());
                }
                for (DayAccepted dayAccepted: acceptedData.getData()) {
                    //System.out.println(year1.GetYear()+"-"+dayAccepted.getYear()+"-"+moth.getMonth()+"-"+dayAccepted.getMonth()+"-"+day.GetNumberOfDay()+"-"+dayAccepted.getDay());

                    if (year1.GetYear() == dayAccepted.getYear() && moth.getMonth() == dayAccepted.getMonth() && day.GetNumberOfDay() == dayAccepted.getDay()){
                        //System.out.println("---------------------------------------");
                        stringBuilder.append(" от других пользователей ");
                        stringBuilder.append(dayAccepted.getMessage());
                        //System.out.print(" от других пользователей " + dayAccepted.getMessage());
                    }
                }


                if (count>=7){
                    stringBuilder.append("\n");
                    //System.out.println();
                    count = 0;
                }
                stringBuilder.append("_");
                //System.out.print("_");
            }
            stringBuilder.append("\n");
            //System.out.println();
        }
        return stringBuilder.toString();
    }
}
