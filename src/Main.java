import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
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

        //Month month = year1.GetMonths()[10];
        //Day day1 = month.GetDays()[12];
        //day1.SetComments("ЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕ");

        for (Month moth :year1.GetMonths()){
            System.out.println(moth.GetNameOfMonth());
            for (Day day : moth.GetDays()){
                System.out.println(day.GetDayOfWeek());
                System.out.println(day.GetNumberOfDay());
                System.out.println(day.GetComments());
            }
            System.out.println();
        }
    }
}