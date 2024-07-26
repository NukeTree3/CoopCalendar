import com.ourcalendar.view.ConsoleUI;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.addTestUser("name1","127.0.0.1",8001);
        consoleUI.start();
    }
}