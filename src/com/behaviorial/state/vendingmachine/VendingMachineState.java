package com.behaviorial.state.vendingmachine;

public interface VendingMachineState {

    public void insertCoin();
    public void returnCoin();
    public void selectItem();
    public void dispense();
    public void refill(int count);
}
