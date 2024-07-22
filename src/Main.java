import com.ourcalendar.view.ConsoleUI;
import java.io.IOException;

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


        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.addTestUser("name1","127.0.0.1",8001);
        consoleUI.start();
    }
}