package com.behaviorial.state.vendingmachine;

public class NoCoinState implements VendingMachineState{

    private VendingMachine machine;

    public NoCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You inserted a quarter");
        machine.setCurrentState(machine.getHasCoinState());
    }

    @Override
    public void returnCoin() {
        System.out.println("You haven’t inserted a coin");
    }

    @Override
    public void selectItem() {
        System.out.println("You selected an item, but there’s no coin");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }

    @Override
    public void refill(int count) {
        System.out.println("Refilling now");
        machine.setCount(count + machine.getCount());
    }
}
