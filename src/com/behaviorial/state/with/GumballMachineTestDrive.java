package com.behaviorial.state.with;

public class GumballMachineTestDrive {

    public static void main(String[] args) {

        System.out.println("=== Gumball Machine State Pattern Test Drive ===\n");

        // 1. Machine with initial inventory
        GumballMachine machine = new GumballMachine(5);

        System.out.println("\n--- Test: Normal purchase flow ---");
        machine.insertQuarter();
        machine.turnCrank();

        System.out.println("\n--- Test: Insert and eject quarter ---");
        machine.insertQuarter();
        machine.ejectQuarter();
        machine.turnCrank();

        System.out.println("\n--- Test: Multiple purchases until sold out ---");
        for (int i = 1; i <= 6; i++) {
            System.out.println("\nAttempt #" + i);
            machine.insertQuarter();
            machine.turnCrank();
        }

        System.out.println("\n--- Test: Interactions after SOLD OUT ---");
        machine.insertQuarter();
        machine.ejectQuarter();
        machine.turnCrank();

        System.out.println("\n=== Test Drive Finished ===");
    }
}