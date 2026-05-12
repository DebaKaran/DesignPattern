package com.behaviorial.itreator;

public class Waitress {

    public void printMenu(Menu menu) {
        Iterator<MenuItem> iterator = menu.createIterator();

        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            System.out.println(item.getName()+" : "+item.getPrice());
        }
    }
}
