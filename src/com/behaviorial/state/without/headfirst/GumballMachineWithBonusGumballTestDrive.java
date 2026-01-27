package com.behaviorial.state.without.headfirst;

public class GumballMachineWithBonusGumballTestDrive {

    public static void main(String[] args) {

        GumballMachineWithBonusGumball machine =
                new GumballMachineWithBonusGumball(25);

        System.out.println("=== Gumball Machine Test Drive (Bonus Gumball) ===");

        // Basic happy path
        machine.insertQuarter();
        machine.turnCrank();

        // Insert and eject
        machine.insertQuarter();
        machine.ejectQuarter();
        machine.turnCrank();

        // Multiple runs to observe WINNER behavior
        for (int i = 1; i <= 15; i++) {
            System.out.println("\n--- Turn " + i + " ---");
            machine.insertQuarter();
            machine.turnCrank();
        }

        // Try using machine after it is sold out
        System.out.println("\n--- Attempt after sold out ---");
        machine.insertQuarter();
        machine.turnCrank();

        System.out.println("\n=== Test Drive Finished ===");
    }
}