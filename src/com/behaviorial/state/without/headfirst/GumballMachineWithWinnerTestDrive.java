package com.behaviorial.state.without.headfirst;

public class GumballMachineWithWinnerTestDrive {

    public static void main(String[] args) {

        GumballMachineWithWinner machine =
                new GumballMachineWithWinner(15);

        System.out.println("---- Test Run Started ----");

        // 1. Normal purchase
        machine.insertQuarter();
        machine.turnCrank();

        // 2. Insert + eject
        machine.insertQuarter();
        machine.ejectQuarter();
        machine.turnCrank();

        // 3. Multiple turns to observe winner behavior
        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Turn " + (i + 1) + " ---");
            machine.insertQuarter();
            machine.turnCrank();
        }

        // 4. Try operating after sold out
        System.out.println("\n--- After Sold Out ---");
        machine.insertQuarter();
        machine.turnCrank();

        System.out.println("---- Test Run Finished ----");
    }
}