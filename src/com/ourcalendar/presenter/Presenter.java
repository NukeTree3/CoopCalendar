package com.ourcalendar.presenter;

import com.ourcalendar.model.date.TimeLine;
import com.ourcalendar.model.date.Year;
import com.ourcalendar.model.service.Service;
import com.ourcalendar.model.user.comments.CommentsEditor;
import com.ourcalendar.model.user.comments.UserChanges;
import com.ourcalendar.model.user.comments.UserComments;
import com.ourcalendar.view.View;

import java.io.IOException;
import java.util.ArrayList;

public class Presenter {

    private Service service;
    private View view;
    private UserComments userComments;
    private UserChanges userChanges;

    public Presenter(View view,int port) throws IOException, ClassNotFoundException {
        this.view = view;
        service = new Service();
        userComments = new UserComments();
        userChanges = new UserChanges();
        service.createUser(port);
    }

    public void addComment(int day, int month, int numberOfYear, String comment) throws IOException, ClassNotFoundException {

        CommentsEditor commentsEditor = new CommentsEditor();

        commentsEditor.addComments(day,month,service.getTimeLine().getTimeLine().get(numberOfYear-2020),comment);

        userChanges.setUserChanges(userComments.addTextPlusDay(service.getTimeLine().getTimeLine().get(numberOfYear-2020).getMonth(month-1).getDay(day-1),month,numberOfYear));

        savedTimeLine();
    }

    public ArrayList<String> getUserChanges(){
        return userChanges.getUserChanges();
    }


    public String outputTable(int numberOfYear){
        return service.outputTable(service.getTimeLine().getTimeLine().get(numberOfYear-2020));
    }


    public void startUser() throws IOException {
        service.startUser();
    }

    public void clientUser(String message) throws IOException, InterruptedException {
        service.clientUser(message);
    }

    public void addUsers(String name, String adress, int port) throws IOException, ClassNotFoundException {
        service.addUsers(name,adress,port);
        savedContactList();
    }

    public ArrayList<String> getConnectionList(){
        return service.getConnectionList();
    }

    public void savedAcceptedData() throws IOException, ClassNotFoundException {
        service.savedAcceptedData();
    }

    public void savedTimeLine() throws IOException, ClassNotFoundException {
        service.savedTimeLine();
    }

    public void savedContactList() throws IOException, ClassNotFoundException {
        service.savedContactList();
    }

    public void stopServer() throws IOException, InterruptedException {
        service.closeServer();
    }

    public boolean deleteContact(String name) throws IOException {
        return service.deleteContact(name);
    }
}