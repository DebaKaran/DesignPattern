package com.behaviorial.state.vendingmachine;

public class VendingMachineTestDrive {

    public static void main(String[] args) {

        // Create a vending machine with 2 items
        VendingMachine machine = new VendingMachine(2);

        System.out.println("=== First Purchase ===");
        machine.insertCoin();
        machine.selectItem();
        machine.dispense();

        System.out.println("\n=== Second Purchase ===");
        machine.insertCoin();
        machine.selectItem();
        machine.dispense();

        System.out.println("\n=== Try to Buy When Sold Out ===");
        machine.insertCoin();
        machine.selectItem();
        machine.dispense();

        System.out.println("\n=== Refill Machine ===");
        machine.refill(3);

        System.out.println("\n=== Purchase After Refill ===");
        machine.insertCoin();
        machine.selectItem();
        machine.dispense();

        System.out.println("\n=== Insert Coin and Return It ===");
        machine.insertCoin();
        machine.returnCoin();

        System.out.println("\n=== Invalid Operation: Select Item Without Coin ===");
        machine.selectItem();

        System.out.println("\n=== Final Item Count: " + machine.getCount() + " ===");
    }
}