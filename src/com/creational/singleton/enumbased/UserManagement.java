package com.creational.singleton.enumbased;

public class UserManagement {

    private final AppConfig config;

    public UserManagement() {
        this.config = AppConfig.getInstance();
    }

    public void printUserDetails() {
        System.out.println("Support Email: " + config.getSupportEmail());
        System.out.println("Application Name: " + config.getAppName());
    }

}
