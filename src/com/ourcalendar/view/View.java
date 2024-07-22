package com.ourcalendar.view;

import java.io.IOException;

public interface View {
    void start() throws IOException, ClassNotFoundException, InterruptedException;
    void printText(String text);
}
