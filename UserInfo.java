package com.example.contactapp;

public class UserInfo {

    String name;
    String desc;
    int imageID;

    public  UserInfo(){
        name = "";
        desc = "";
        imageID  = 0;
    }

    public UserInfo(String name, String desc, int imageLocation) {
        this.name = name;
        this.desc = desc;
        this.imageID = imageLocation;
    }
}