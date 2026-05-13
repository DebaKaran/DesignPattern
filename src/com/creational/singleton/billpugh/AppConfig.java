package com.creational.singleton.billpugh;

/**
 * Enum-based Singleton implementation.
 *
 * Advantages:
 * - Thread-safe by JVM design
 * - Serialization-safe
 * - Reflection-safe
 * - Very concise
 */

public class AppConfig {

    private final String appName;
    private final String supportEmail;
    private final Double taxPercentage;
    private final String currency;
    private final int retry;

    private AppConfig() {
        this.appName = "spring-boot";
        this.supportEmail = "abc@gmail.com";
        this.taxPercentage = 0.20;
        this.currency = "INR";
        this.retry = 4;
    }

    public String getAppName() {
        return appName;
    }

    public String getSupportEmail() {
        return supportEmail;
    }

    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public String getCurrency() {
        return currency;
    }

    public int getRetry() {
        return retry;
    }

    // Inner class to provide instance of class
    private static class SingletonHolder {
        private static final AppConfig INSTANCE = new AppConfig();
    }
    //Public static getInstance() method → provides global access.
    public static AppConfig getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
