import com.ourcalendar.model.date.CreateYear;
import com.ourcalendar.model.date.Year;
import com.ourcalendar.model.user.CommentsEditor;
import com.ourcalendar.view.Table;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws UnknownHostException {

        /*
        таски на ближайшее время:
        1)доделать связь р2р
        2)сделать так, чтоб каждый изменял свой календарь и это отображалось у каждого
        3)протестировать на растоянии

        основная идея синхронизации конечного приложения: синхронизация пользователей к определенному времени,
        пробуждать каждого пользователя через определенное время и синхронизироваться с остальными
         */

        InetAddress ip;
        String hostname;
        ip = InetAddress.getLocalHost();
        hostname = ip.getHostName();
        System.out.println(ip);
        System.out.println(hostname);

        LocalDate date = LocalDate.now();
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.lengthOfMonth());

        CreateYear year = new CreateYear();
        Year year1 = year.CreateYear(2024);



        //com.ourcalendar.model.date.Month month = year1.GetMonths()[10];
        //com.ourcalendar.model.date.Day day1 = month.GetDays()[12];
        //day1.SetComments("ЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕ");

//        for (com.ourcalendar.model.date.Month moth :year1.GetMonths()){
//            System.out.println(moth.GetNameOfMonth());
//            for (com.ourcalendar.model.date.Day day : moth.GetDays()){
//                System.out.println(day.GetDayOfWeek());
//                System.out.println(day.GetNumberOfDay());
//                System.out.println(day.GetComments());
//            }
//            System.out.println();
//        }



        CommentsEditor commentsEditor = new CommentsEditor();
        commentsEditor.addComments(9,7,year1,"ЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕ");

        Table table = new Table();
        table.CreateTable(year1);


    }
}