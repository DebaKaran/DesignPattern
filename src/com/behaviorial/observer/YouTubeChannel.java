package com.behaviorial.observer;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject{

    private String video;
    private List<Observer> subscibers;

    public YouTubeChannel() {
        this.subscibers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        subscibers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscibers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer subsriber : subscibers) {
            subsriber.notify(video);
        }
    }

    public void uploadVideo(String video) {
        this.video = video;
        System.out.println("New video uploaded: " + video);
        notifyObserver();
    }
}
