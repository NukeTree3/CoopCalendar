import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.time.DayOfWeek;

public class Table {
//    private CreateYear year = new CreateYear();
//    private Year year1 = year.CreateYear(2024);

    public void CreateTable(Year year1){
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
