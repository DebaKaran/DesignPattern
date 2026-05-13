package com.creational.singleton.enumbased;

/**
 * Enum-based Singleton implementation.
 *
 * Advantages:
 * - Thread-safe by JVM design
 * - Serialization-safe
 * - Reflection-safe
 * - Very concise
 */

public enum AppConfig {
    INSTANCE;

    private final String appName;
    private final String supportEmail;
    private final Double taxPercentage;
    private final String currency;
    private final int retry;

    // Enum constructor is implicitly private.
    AppConfig() {
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

    /**
     * Optional convenience method.
     * Not required, but some teams prefer a method-based access style.
     */
    public static AppConfig getInstance() {
        return INSTANCE;
    }
}
