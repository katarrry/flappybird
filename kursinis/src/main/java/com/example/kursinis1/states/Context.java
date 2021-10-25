package com.example.kursinis1.states;

public class Context {
    private static State state;

    public Context() {
        state = new StartState();
    }

    public void setState(State state) {
        Context.state = state;
    }

    public void doAction() {
        state.doAction(this);
    }

}
