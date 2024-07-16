package com.ourcalendar.model.filehandler;

import com.ourcalendar.model.user.UserComments;

import java.io.IOException;

public interface Writeble {
    void saved(UserComments userComments) throws IOException;
    UserComments download() throws IOException, ClassNotFoundException;
}
