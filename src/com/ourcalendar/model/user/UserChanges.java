package com.ourcalendar.model.user;

import java.util.ArrayList;

public class UserChanges {
    private ArrayList<String> userChanges = new ArrayList();

    public void setUserChanges(String str) {
        this.userChanges.add(str);
    }

    public ArrayList<String> getUserChanges(){
        return userChanges;
    }
}
