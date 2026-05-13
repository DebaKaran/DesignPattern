package com.creational.singleton.enumbased;

public class SingletonTestDrive {

        public static void main(String[] args) {
            AppConfig config1 = AppConfig.INSTANCE;
            AppConfig config2 = AppConfig.INSTANCE;

            System.out.println(config1 == config2); // true

            UserManagement userManagement = new UserManagement();
            userManagement.printUserDetails();
        }
}
