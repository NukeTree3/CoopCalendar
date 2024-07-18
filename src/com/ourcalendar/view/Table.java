package com.ourcalendar.view;

import com.ourcalendar.model.user.accepteddata.AcceptedData;
import com.ourcalendar.model.user.accepteddata.DayAccepted;
import com.ourcalendar.model.date.Day;
import com.ourcalendar.model.date.Month;
import com.ourcalendar.model.date.Year;

import java.time.DayOfWeek;

public class Table {
//    private com.ourcalendar.model.date.createYear year = new com.ourcalendar.model.date.createYear();
//    private com.ourcalendar.model.date.Year year1 = year.com.ourcalendar.model.date.createYear(2024);

    public void CreateTable(Year year1, AcceptedData acceptedData){
        //AcceptedData acceptedData = new AcceptedData();
        for (Month moth :year1.GetMonths()){
            System.out.println(moth.GetNameOfMonth());
            int count = 0;
            System.out.println("MON_TUE_WED_THU_FRI_SAT_SUN");

            for (Day day : moth.GetDays()){
                count++;
                DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.GetDayOfWeek());
                int a = 0;
                while (dayOfWeek.getValue()-a!=1 && day.GetNumberOfDay()==1){
                    System.out.print("---");
                    a++;
                    count++;
                }


//                System.out.print(day.GetDayOfWeek());
//                System.out.print("/");
                System.out.print(day.GetNumberOfDay());
                System.out.print("/");
                System.out.print(day.GetComments());
                for (DayAccepted dayAccepted: acceptedData.getData()) {
                    //System.out.println(year1.GetYear()+"-"+dayAccepted.getYear()+"-"+moth.getMonth()+"-"+dayAccepted.getMonth()+"-"+day.GetNumberOfDay()+"-"+dayAccepted.getDay());

                    if (year1.GetYear() == dayAccepted.getYear() && moth.getMonth() == dayAccepted.getMonth() && day.GetNumberOfDay() == dayAccepted.getDay()){
                        //System.out.println("---------------------------------------");
                        System.out.print(" от других пользователей " + dayAccepted.getMessage());
                    }
                }


                if (count>=7){
                    System.out.println();
                    count = 0;
                }
                System.out.print("_");
            }
            System.out.println();
        }
    }
}
