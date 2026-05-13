package com.behaviorial.state.vendingmachine;

public class VendingMachine {

    private VendingMachineState noCoinState;
    private VendingMachineState hasCoinState;
    private VendingMachineState dispenseState;
    private VendingMachineState soldOutState;

    private VendingMachineState currentState;
    private int count;

    public VendingMachine(int count) {
        this.noCoinState = new NoCoinState(this);
        this.hasCoinState = new HasCoinState(this);
        this.dispenseState = new DispenseState(this);
        this.soldOutState = new SoldoutState(this);

        if(count <= 0) {
            this.currentState = soldOutState;
            this.count = 0;
        } else {
            this.currentState = noCoinState;
            this.count = count;
        }
    }

    public VendingMachineState getNoCoinState() {
        return noCoinState;
    }

    public VendingMachineState getHasCoinState() {
        return hasCoinState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public VendingMachineState getSoldOutState() {
        return soldOutState;
    }

    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void returnCoin() {
        currentState.returnCoin();
    }
    public void selectItem() {
        currentState.selectItem();
    }
    public void dispense() {
        currentState.dispense();
    }

    public void refill(int count){
        currentState.refill(count);
    }


}
