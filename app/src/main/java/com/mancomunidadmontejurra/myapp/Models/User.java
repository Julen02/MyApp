package com.mancomunidadmontejurra.myapp.Models;

import java.io.Serializable;

public class User  implements Serializable {
    private int id;
    private String name;
    private int img;
    private String password;
    private String telef;

    public User() {}

    public User(String name, String telef) {
        this.name = name;
        this.telef = telef;
        this.password = "";
        this.img = 0;
    }

    public User(String name, String telef, String password) {
        this(telef, password);
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return telef.equals(user.telef);
    }

}
