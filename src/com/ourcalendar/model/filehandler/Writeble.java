package com.ourcalendar.model.filehandler;

import com.ourcalendar.model.user.accepteddata.AcceptedData;
import com.ourcalendar.model.date.TimeLine;

import java.io.IOException;

public interface Writeble {
    void savedTimeLine(TimeLine timeLine) throws IOException;
    void savedAcceptedData(AcceptedData acceptedData) throws IOException;
    TimeLine downloadTimeLine() throws IOException, ClassNotFoundException;
    AcceptedData downloadAcceptedData() throws IOException, ClassNotFoundException;
}
