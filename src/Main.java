import com.ourcalendar.model.date.CreateYear;
import com.ourcalendar.model.date.Year;
import com.ourcalendar.model.service.Service;
import com.ourcalendar.model.user.comments.CommentsEditor;
import com.ourcalendar.presenter.Presenter;
import com.ourcalendar.view.Table;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        /*
        таски на ближайшее время:
        1)доделать связь р2р+
        2)сделать так, чтоб каждый изменял свой календарь и это отображалось у каждого +
        3)протестировать на растоянии

        основная идея синхронизации конечного приложения: синхронизация пользователей к определенному времени,
        пробуждать каждого пользователя через определенное время и синхронизироваться с остальными
         */

//        InetAddress ip;
//        String hostname;
//        ip = InetAddress.getLocalHost();
//        hostname = ip.getHostName();
//        System.out.println(ip);
//        System.out.println(hostname);
//
//        LocalDate date = LocalDate.now();
//        System.out.println(date.getDayOfMonth());
//        System.out.println(date.getMonth());
//        System.out.println(date.getDayOfWeek());
//        System.out.println(date.lengthOfMonth());

        CreateYear year = new CreateYear();
        Service service = new Service();
        Service service1 = new Service();
        Year year1 = year.createYear(2024);


        Presenter presenter = new Presenter();

        CommentsEditor commentsEditor = new CommentsEditor();
        presenter.addComment(9,7,year1,"ЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕ");
        //commentsEditor.addComments(9,7,year1,"ЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕЕ");

        Table table = new Table();
        service.createUser(8000);
        service1.createUser(8001);
        service.startUser();
        service1.startUser();
        service1.addUsers("127.0.0.1",8000);
        //User user = new User(8000);
        //User user1 = new User(8001);
        //user1.start();
        //user.start();
        //user1.addUser("127.0.0.1",8000);

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1-добавление сообщения к дате, 2-добавление нового пользователя, 3-отправление изменений, 4-вывод календаря, 5-вывод списка всех контактов, 6-вывод списка изменений");
            switch (scanner.nextLine()){
                case("1"):{
                    System.out.println("Введите номер дня");
                    String day = scanner.nextLine();
                    System.out.println("Введите номер месяца");
                    String month = scanner.nextLine();
                    System.out.println("Введите сообщение");
                    String message = scanner.nextLine();
                    presenter.addComment(Integer.parseInt(day), Integer.parseInt(month),year1,message);
                    break;
                }

                case("2"):{
                    System.out.println("Введите адрес");
                    String address = scanner.nextLine();
                    System.out.println("Введите порт");
                    String port = scanner.nextLine();
                    service.addUsers(address,Integer.parseInt(port));
                    break;
                }

                case("3"):{
                    System.out.println("Отправка...");
                    //user.start();
                    StringBuilder stringBuilder= new StringBuilder();
                    for(String comments : presenter.getUserChanges()){
                        stringBuilder.append(comments);
                        stringBuilder.append("#@@#");
                    }
                    System.out.println(stringBuilder.toString());
                    service.clientUser(stringBuilder.toString());
                    //user.client(stringBuilder.toString());
                    break;
                }

                case("4"):{
                    System.out.println("Вот");
                    service.outputTable(year1);
                    //table.CreateTable(year1);
                    break;
                }

                case("5"):{
                    System.out.println("Вот");
                    //for (String connecton: user.getConnectionList()) {
                    for (String connecton: service.getConnectionList()) {
                        System.out.println(connecton);
                    }

                    break;
                }

                case("6"):{
                    System.out.println("Вот");
                    System.out.println(presenter.getUserChanges().toString());
                    break;
                }

                case("7"):{
                    System.out.println("Вот");
                    service1.clientUser("12##!!##10##!!##0##!!##))))))))))))");
                    break;
                }


                default:{
                    System.out.println("Ошибка ввода");
                }
            }
        }
    }
}