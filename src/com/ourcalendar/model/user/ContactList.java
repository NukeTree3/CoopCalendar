package com.ourcalendar.model.user;

import java.io.Serializable;
import java.util.ArrayList;

public class ContactList implements Serializable {
    private ArrayList<String> contactList;
    public ContactList(){
        contactList = new ArrayList<>();
    }
    public void addContact(String name, String address, int port){
        String builder = name + ":" + address + ":" + port;
        contactList.add(builder);
    }
    public ArrayList<String> getContactList(){
        return contactList;
    }

    public boolean deleteContact(String name){
        int i = findContact(name);
        if(i>=0){
            contactList.remove(i);
            return true;
        }
        else {
            return false;
        }
    }

    private int findContact(String name) {
        for (int i = 0; i < contactList.size(); i++) {
            if (name.equals(contactList.get(i).split(":")[0])) {
                return i;
            }
        }
        return -1;

//        for (String contact: contactList) {
//            if(name.equals(contact.split(":")[0])){
//                return ;
//            }
//        }
    }
}
