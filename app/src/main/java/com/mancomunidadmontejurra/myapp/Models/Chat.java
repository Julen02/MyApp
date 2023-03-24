package com.mancomunidadmontejurra.myapp.Models;


import java.util.List;

public class Chat  {


    private int id;

    private boolean group;
    private String nameGroup;
    private int img;

    private List<Message> messages;
    private List<User> participants;

    public Chat() {
    }

    public Chat(List<User> participants, boolean group) {

        this.group = group;
        this.nameGroup = "";
    }

    public Chat(List<Message> messages, List<User> participants, boolean group) {
        this(participants, group);
        this.messages = messages;
    }

    public int getImg() {
        return group ? this.img : this.getOtherUser().getImg() ;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return ! group ? this.getOtherUser().getName() :this.nameGroup;
    }

    public User getOtherUser() {
        if (!group) {
            for (User user : participants) {
               // if (user.getId() != MyApplication.currentUser.getId()) {
                 //   return user;
                //}
            }
        }

        return null;
    }

    public Boolean addUser(User newUser) {
        if (participants.contains(newUser) || !group) return false;

        participants.add(newUser);
        return true;
    }

    public String getLastMessage() {
        if (messages.size() > 0) {
            return messages.get(messages.size() - 1).getText();
        } else {
            return "";
        }

    }

    public boolean setName(String name) {
        if (group) {
            this.nameGroup = name;
            return true;
        }

        this.nameGroup = "";
        return false;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
