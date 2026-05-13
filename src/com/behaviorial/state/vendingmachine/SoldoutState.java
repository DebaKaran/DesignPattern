package com.behaviorial.state.vendingmachine;

public class SoldoutState implements VendingMachineState{

    private VendingMachine machine;

    public SoldoutState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You can’t insert a coin");
    }

    @Override
    public void returnCoin() {
        System.out.println("You can’t return the coin");
    }

    @Override
    public void selectItem() {
        System.out.println("You cant select an item");
    }

    @Override
    public void dispense() {
        System.out.println("You can't dispense now");
    }

    @Override
    public void refill(int count) {
        System.out.println("Refilling now");
        machine.setCount(count);
        machine.setCurrentState(machine.getNoCoinState());
    }
}
