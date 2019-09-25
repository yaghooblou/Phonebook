package com.phonebook.phonebook.entity;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phone_id;
    private String title;
    private String phone;
    @ManyToOne
    private User user;

    public int getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
