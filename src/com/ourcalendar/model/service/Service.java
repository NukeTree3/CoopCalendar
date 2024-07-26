package com.ourcalendar.model.service;

import com.ourcalendar.model.user.ContactList;
import com.ourcalendar.model.user.accepteddata.AcceptedData;
import com.ourcalendar.model.date.CreateTimeLine;
import com.ourcalendar.model.date.TimeLine;
import com.ourcalendar.model.date.Year;
import com.ourcalendar.model.filehandler.FIleHandler;
import com.ourcalendar.model.user.User;
import com.ourcalendar.model.user.comments.UserChanges;
import com.ourcalendar.model.user.comments.UserComments;
import com.ourcalendar.model.table.Table;

import java.io.IOException;
import java.util.ArrayList;

public class Service {
    AcceptedData acceptedData;
    FIleHandler fIleHandler;
    CreateTimeLine createTimeLine;
    TimeLine timeLine = new TimeLine();
    private UserComments userComments;
    private UserChanges userChanges;
    User user;
    ContactList contactList;

    public Service(){
        fIleHandler = new FIleHandler();
        createTimeLine = new CreateTimeLine();
        userComments = new UserComments();
        userChanges = new UserChanges();
        try {
            downloadTimeLine();
        }
        catch (Exception e){
            createTimeLine.createTimeLine(timeLine);
        }
        try {
            downloadAcceptedData();
        }
        catch (Exception e){
            acceptedData = new AcceptedData();
        }
        try {
            downloadContactList();
        }
        catch (Exception e){
            contactList = new ContactList();
        }
    }

    public TimeLine getTimeLine(){
        return timeLine;
    }

    public void closeServer() throws IOException {
        fIleHandler.savedAcceptedData(acceptedData);
        user.stopServer();
    }

    public Year createYear(int year){
        return createTimeLine.createYear(year);
    }

    public String outputTable(Year year){
        Table table = new Table();
        return table.createTable(year, acceptedData);
    }

    public void createUser(int port){
        this.user = new User(port,acceptedData);
    }

    public void startUser() throws IOException {
        user.start();
    }

    public void clientUser(String message) throws IOException, InterruptedException {
        user.client(message, contactList.getContactList());
    }

    public void addUsers(String name, String adress, int port){
        contactList.addContact(name,adress,port);
    }

    public ArrayList<String> getConnectionList(){
        return contactList.getContactList();
    }

    public void savedAcceptedData() throws IOException {
        fIleHandler.savedAcceptedData(acceptedData);
    }

    public void savedTimeLine() throws IOException {
        fIleHandler.savedTimeLine(timeLine);
    }

    public void savedContactList() throws IOException {
        fIleHandler.saveContactList(contactList);
    }

    public void downloadContactList() throws IOException, ClassNotFoundException {
        contactList=fIleHandler.downloadContactList();
    }
    public void downloadTimeLine() throws IOException, ClassNotFoundException {
        timeLine=fIleHandler.downloadTimeLine();
    }

    public void downloadAcceptedData() throws IOException, ClassNotFoundException {
        acceptedData=fIleHandler.downloadAcceptedData();
    }

    public boolean deleteContact(String name) throws IOException {
        boolean bool = contactList.deleteContact(name);
        savedContactList();
        return bool;
    }
}
