package com.ourcalendar.model.filehandler;

import com.ourcalendar.model.user.ContactList;
import com.ourcalendar.model.user.accepteddata.AcceptedData;
import com.ourcalendar.model.date.TimeLine;

import java.io.*;

public class FIleHandler implements Writeble {
    @Override
    public void savedTimeLine(TimeLine timeLine) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./src/savesTimeLine.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(timeLine);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public void savedAcceptedData(AcceptedData acceptedData) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./src/savesAcceptedData.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(acceptedData);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public void saveContactList(ContactList contactList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./src/savesContactList.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(contactList);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public TimeLine downloadTimeLine() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("./src/savesTimeLine.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TimeLine timeLine = (TimeLine) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return timeLine;
    }

    @Override
    public ContactList downloadContactList() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("./src/savesContactList.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ContactList contactList = (ContactList) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return contactList;
    }

    @Override
    public AcceptedData downloadAcceptedData() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("./src/savesAcceptedData.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        AcceptedData acceptedData = (AcceptedData) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return acceptedData;
    }
}
