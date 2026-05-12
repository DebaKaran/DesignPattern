package com.behaviorial.observer;

public class ObserverTest {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Subscriber deba = new Subscriber("Deba");
        Subscriber bob = new Subscriber("Bob");
        Subscriber abc = new Subscriber("abc");

        channel.subscribe(deba);
        channel.subscribe(bob);
        channel.subscribe(abc);

        channel.uploadVideo("Observer Design Pattern Explained");

        channel.unsubscribe(bob);

        channel.uploadVideo("Spring Boot Events Tutorial");
    }
}
