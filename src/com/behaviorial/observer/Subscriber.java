package com.behaviorial.observer;

public class Subscriber implements Observer{
    private String subsrberName;

    public Subscriber(String subsrberName) {
        this.subsrberName = subsrberName;
    }

    @Override
    public void notify(String videoTitle) {
        System.out.println(subsrberName + " received notification: " + videoTitle);
    }
}
