package com.behaviorial.state.vendingmachine;

public class HasCoinState implements VendingMachineState{
    private VendingMachine machine;

    public HasCoinState(VendingMachine machine) {
        this.machine = machine;
    }
    @Override
    public void insertCoin() {
        System.out.println("You can’t insert another coin");
    }

    @Override
    public void returnCoin() {
        System.out.println("Coin returned");
        machine.setCurrentState(machine.getNoCoinState());
    }

    @Override
    public void selectItem() {
        System.out.println("You selected an intem...");
        machine.setCurrentState(machine.getDispenseState());
    }

    @Override
    public void dispense() {
        System.out.println("You can't dispense now");
    }

    @Override
    public void refill(int count) {
        System.out.println("Refilling now");
        machine.setCount(count + machine.getCount());
    }
}
