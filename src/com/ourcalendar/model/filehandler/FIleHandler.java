package com.ourcalendar.model.filehandler;

import com.ourcalendar.model.user.UserComments;

import java.io.*;

public class FIleHandler implements Writeble {
    @Override
    public void saved(UserComments userComments) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("saves");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(userComments);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public UserComments download() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("saves");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        UserComments userComments = (UserComments) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return userComments;
    }
}
