package com.behaviorial.itreator;

public class MenuTestDrive {
    public static void main(String[] args) {
        Menu pancakeMenu = new PancakeHouseMenu();
        Menu dinnerMenu = new DinerMenu();

        Waitress waitress = new Waitress();

        System.out.println("PANCAKE HOUSE MENU");
        waitress.printMenu(pancakeMenu);

        System.out.println("\nDINER MENU");
        waitress.printMenu(dinnerMenu);
    }
}
