package com.ourcalendar.model.filehandler;

import com.ourcalendar.model.user.accepteddata.AcceptedData;
import com.ourcalendar.model.date.TimeLine;

import java.io.*;

public class FIleHandler implements Writeble {
    @Override
    public void savedTimeLine(TimeLine timeLine) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("savesTimeLine");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(timeLine);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public void savedAcceptedData(AcceptedData acceptedData) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("savesAcceptedData");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(acceptedData);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public TimeLine downloadTimeLine() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("savesTimeLine");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TimeLine timeLine = (TimeLine) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return timeLine;
    }

    @Override
    public AcceptedData downloadAcceptedData() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("savesTimeLine");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        AcceptedData acceptedData = (AcceptedData) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return acceptedData;
    }
}
