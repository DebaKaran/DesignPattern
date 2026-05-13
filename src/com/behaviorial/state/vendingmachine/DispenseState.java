package com.behaviorial.state.vendingmachine;

public class DispenseState implements VendingMachineState{

    private VendingMachine machine;

    public DispenseState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You can’t insert another coin");
    }

    @Override
    public void returnCoin() {
        System.out.println("You can’t return the coin");
    }

    @Override
    public void selectItem() {
        System.out.println("You cant select another item");
    }

    @Override
    public void dispense() {
        System.out.println("An Item comes rolling out the slot");
        machine.setCount(machine.getCount() - 1);
        if(machine.getCount() == 0) {
            machine.setCurrentState(machine.getSoldOutState());
        } else {
            machine.setCurrentState(machine.getNoCoinState());
        }
    }

    @Override
    public void refill(int count) {
        System.out.println("Refilling now");
        machine.setCount(count + machine.getCount());
    }
}
