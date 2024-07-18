package com.ourcalendar.view;

import com.ourcalendar.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Ошибка ввода";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() throws IOException, ClassNotFoundException {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        helloWorld();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish(){
        System.out.println("Bye, world");
        work=false;
    }

    public void helloWorld(){
        System.out.println("Hello world");
    }

    public void printMenu(){
        System.out.println(mainMenu.outputMenuInfo());
    }

    private void execute() throws IOException, ClassNotFoundException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }



    @Override
    public void printText(String text) {

    }

//    public void outputTable(){
//        presenter.outputTable(presenter.getTimeline().getTimeLine().get(0));
//    }


    public void addComment(){
        System.out.println("Введите номер дня");
        String day = scanner.nextLine();
        System.out.println("Введите номер месяца");
        String month = scanner.nextLine();
        System.out.println("Введите номер года");
        String year = scanner.nextLine();
        System.out.println("Введите сообщение");
        String message = scanner.nextLine();
        presenter.addComment(Integer.parseInt(day), Integer.parseInt(month),presenter.outputYear(Integer.parseInt(year)),message);
    }

    public void addUser(){
        System.out.println("Введите адрес");
        String address = scanner.nextLine();
        System.out.println("Введите порт");
        String port = scanner.nextLine();
        presenter.addUsers(address,Integer.parseInt(port));
    }

    public void sendMyComments() throws IOException, InterruptedException {
        System.out.println("Отправка...");
        //user.start();
        StringBuilder stringBuilder= new StringBuilder();
        for(String comments : presenter.getUserChanges()){
            stringBuilder.append(comments);
            stringBuilder.append("#@@#");
        }
        System.out.println(stringBuilder);
        presenter.clientUser(stringBuilder.toString());
    }

    public void getTable(){
        System.out.println("Вот");
        presenter.outputTable(Integer.parseInt(scanner.nextLine()));
    }

    public void getConnects(){
        System.out.println("Вот");
        //for (String connecton: user.getConnectionList()) {
        for (String connecton: presenter.getConnectionList()) {
            System.out.println(connecton);
        }
    }

    public void getCheanges(){
        System.out.println("Вот");
        System.out.println(presenter.getUserChanges().toString());
    }

    public void testSendToMe() throws IOException, InterruptedException {
        System.out.println("Вот");

        presenter.clientUser("12##!!##10##!!##0##!!##))))))))))))");
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
}
