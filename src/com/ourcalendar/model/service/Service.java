package com.ourcalendar.model.service;

import com.ourcalendar.model.user.accepteddata.AcceptedData;
import com.ourcalendar.model.date.CreateYear;
import com.ourcalendar.model.date.TimeLine;
import com.ourcalendar.model.date.Year;
import com.ourcalendar.model.filehandler.FIleHandler;
import com.ourcalendar.model.user.comments.CommentsEditor;
import com.ourcalendar.model.user.User;
import com.ourcalendar.model.user.comments.UserChanges;
import com.ourcalendar.model.user.comments.UserComments;
import com.ourcalendar.view.Table;

import java.io.IOException;
import java.util.ArrayList;

public class Service {
    AcceptedData acceptedData;
    FIleHandler fIleHandler;
    CreateYear createYear;
    TimeLine timeLine = new TimeLine();
    private UserComments userComments;
    private UserChanges userChanges;
    User user;

    public Service() throws IOException, ClassNotFoundException {
        acceptedData = new AcceptedData();
        fIleHandler = new FIleHandler();
        createYear = new CreateYear();
        userComments = new UserComments();
        userChanges = new UserChanges();
        if(fIleHandler.downloadTimeLine()!=null){
            download();
        }
        else{
            createYear.createTimeLine();
        }
    }

    public TimeLine getTimeLine(){
        return timeLine;
    }


    public Year createYear(int year){
        return createYear.createYear(year);
    }

    public void outputTable(Year year){
        Table table = new Table();
        table.CreateTable(year, acceptedData);
    }

    public void addComment(int day, int month, Year year, String comment){
        CommentsEditor commentsEditor = new CommentsEditor();
        UserComments userComments = new UserComments();
        commentsEditor.addComments(day, month, year, comment);
        userComments.addTextPlusDay(year.getMonth(month-1).getDay(day-1), month, year.GetYear());
    }

    public void createUser(int port){
        this.user = new User(port,acceptedData);
    }

    public void startUser() throws IOException {
        user.start();
    }

    public void clientUser(String message) throws IOException, InterruptedException {
        user.client(message);
    }

    public void addUsers(String adress, int port){
        user.addUser(adress, port);
    }

    public ArrayList<String> getConnectionList(){
        return user.getConnectionList();
    }

    public void saved() throws IOException, ClassNotFoundException {
        fIleHandler.savedAcceptedData(acceptedData);
        fIleHandler.savedTimeLine(timeLine);
    }

    public void download() throws IOException, ClassNotFoundException {
        acceptedData=fIleHandler.downloadAcceptedData();
        timeLine=fIleHandler.downloadTimeLine();
    }

    public ArrayList<String> getUserChanges(){
        return userChanges.getUserChanges();
    }
}
