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
        presenter = new Presenter(this,login());
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException, InterruptedException {
        helloWorld();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() throws IOException {
        stopServer();
        System.out.println("Bye, world");
        work=false;
    }

    public void helloWorld(){
        System.out.println("Hello world");
    }

    public void printMenu(){
        System.out.println(mainMenu.outputMenuInfo());
    }

    private void execute() throws IOException, ClassNotFoundException, InterruptedException {
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


    public void addComment() throws IOException, ClassNotFoundException {
        System.out.println("Введите номер дня");
        String day = scanner.nextLine();
        System.out.println("Введите номер месяца");
        String month = scanner.nextLine();
        System.out.println("Введите номер года");
        String year = scanner.nextLine();
        System.out.println("Введите сообщение");
        String message = scanner.nextLine();
        presenter.addComment(Integer.parseInt(day), Integer.parseInt(month),Integer.parseInt(year),message);
    }

    public void addUser() throws IOException {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите адрес");
        String address = scanner.nextLine();
        System.out.println("Введите порт");
        String port = scanner.nextLine();
        presenter.addUsers(name,address,Integer.parseInt(port));
    }

    public void addTestUser(String name,String address, int port) throws IOException {
        presenter.addUsers(name,address,port);
    }

    public void sendMyComments() throws IOException, InterruptedException {
        System.out.println("Отправка...");
        StringBuilder stringBuilder= new StringBuilder();
        for(String comments : presenter.getUserChanges()){
            presenter.getUserChanges();
            stringBuilder.append(comments);
            stringBuilder.append("#@@#");
        }
        presenter.clientUser(stringBuilder.toString());
    }


    public void getConnects(){
        System.out.println("Вот");
        for (String connecton: presenter.getConnectionList()) {
            System.out.println(connecton);
        }
    }


    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void outputTable(){
        System.out.println("Введите номер года");
        System.out.println(presenter.outputTable(Integer.parseInt(scanner.nextLine())));
    }

    public int login(){
        System.out.println("введите ваш порт");
        return Integer.parseInt(scanner.nextLine());
    }

    public void stopServer() throws IOException {
        System.out.println("сервер остановлен");
        presenter.stopServer();
    }

    public void startServer() throws IOException {
        System.out.println("сервер запущен");
        presenter.startUser();
    }

    public void deleteContact() throws IOException {
        System.out.println("Введите имя пользователя для удаления");
        String name = scanner.nextLine();
        if (presenter.deleteContact(name)){
            System.out.println("Пользователь удален");
        }
        else {
            System.out.println("Ошибка, такого пользователя нет");
        }
    }
}
