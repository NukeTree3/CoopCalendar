import com.ourcalendar.view.ConsoleUI;

import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.addTestUser("name1","127.0.0.1",8000);
        consoleUI.start();
        //consoleUI.addTestUser("name1","127.0.0.1",8001);
    }
}
