package com.ourcalendar.model.filehandler;

import com.ourcalendar.model.user.ContactList;
import com.ourcalendar.model.user.accepteddata.AcceptedData;
import com.ourcalendar.model.date.TimeLine;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writeble {
    void savedTimeLine(TimeLine timeLine) throws IOException;
    void savedAcceptedData(AcceptedData acceptedData) throws IOException;
    void saveContactList(ContactList contactList) throws IOException;
    TimeLine downloadTimeLine() throws IOException, ClassNotFoundException;
    AcceptedData downloadAcceptedData() throws IOException, ClassNotFoundException;
    ContactList downloadContactList() throws IOException, ClassNotFoundException;
}
