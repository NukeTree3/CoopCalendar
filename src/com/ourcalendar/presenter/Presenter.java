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

    public Presenter(View view) throws IOException, ClassNotFoundException {
        this.view = view;
        service = new Service();
        userComments = new UserComments();
        userChanges = new UserChanges();
    }

    public void addComment(int day, int month, Year year, String comment){

        CommentsEditor commentsEditor = new CommentsEditor();

        commentsEditor.addComments(day,month,year,comment);

        userChanges.setUserChanges(userComments.addTextPlusDay(year.getMonth(month-1).getDay(day-1),month,year.GetYear()));
    }



    public ArrayList<String> getUserChanges(){
        return service.getUserChanges();
        //return userChanges.getUserChanges();
    }





    public TimeLine getTimeline(){
        return service.getTimeLine();
    }

    public Year createYear(int year){
        return service.createYear(year);
    }

    public Year outputYear(int numberOfYear){
        return service.getTimeLine().getTimeLine().get(numberOfYear);
    }

    public void outputTable(int numberOfYear){
        service.outputTable(service.getTimeLine().getTimeLine().get(numberOfYear));
        //service.outputTable(year);
    }

    public void createUser(int port){
        service.createUser(port);
    }

    public void startUser() throws IOException {
        service.startUser();
    }

    public void clientUser(String message) throws IOException, InterruptedException {
        service.clientUser(message);
    }

    public void addUsers(String adress, int port){
        service.addUsers(adress,port);
    }

    public ArrayList<String> getConnectionList(){
        return service.getConnectionList();
    }

    public void saved() throws IOException, ClassNotFoundException {
        service.saved();
    }

    public void download() throws IOException, ClassNotFoundException {
        service.download();
    }
}