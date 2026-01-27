package com.behaviorial.state.with;

public class GumballMachine {

    State soldOutState;
    State soldState;
    State hasQuarterState;
    State noQuarterState;

    State currentState;
    int count;

    public GumballMachine(final int count) {

        this.soldState = new SoldState(this);
        this.soldOutState = new SoldOutState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.noQuarterState = new NoQuarterState(this);

        this.count = count;

        if(count <= 0) {
            this.currentState = soldOutState;
        } else {
            this.currentState = noQuarterState;
        }
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void insertQuarter() {
        currentState.insertQuarter();
    }
    public void ejectQuarter() {
        currentState.ejectQuarter();
    }
    public void turnCrank() {
        currentState.turnCrank();
        currentState.dispense();
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    public int getCount() {
        return count;
    }
}
