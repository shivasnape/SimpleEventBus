package com.snape.shivichu.sampleeventbus.model;

/**
 * *created by Shivichu 02-03-2019
 **/


public class MessageEvent {
    public String name;
    public String email;

    public MessageEvent(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
