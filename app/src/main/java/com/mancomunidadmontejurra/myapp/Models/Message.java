package com.mancomunidadmontejurra.myapp.Models;



import java.util.Date;



public class Message {


    private int id;
    private String text;
    private User sender;
    private Date date;

    public Message() {}

    public Message(String text, User sender, Date date) {

        this.text = text;
        this.sender = sender;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
