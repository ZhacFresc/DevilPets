package com.example.devilpetsforme;

import java.util.ArrayList;

public class Pets {
    private String name;
    private ArrayList<String> photoUrls;
    private int id;
    private String status;

    public String getName() {
        return name;
    }
    public ArrayList<String> getImage() {return photoUrls;}
    public int getId(){return id;}
    public String getStatus(){return status;};

    public void setName(String name){this.name = name;}
    public void setId(int id){this.id = id;}
    public void setStatus(String status){this.status = status;}
}
