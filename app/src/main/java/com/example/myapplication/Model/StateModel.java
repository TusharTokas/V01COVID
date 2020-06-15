package com.example.myapplication.Model;

public class StateModel {
    private String stateName;
    private String stateCase;

    public StateModel(String stateName, String stateCase) {
        this.stateName = stateName;
        this.stateCase =stateCase;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCase() {
        return stateCase;
    }

    public void setStateCase(String stateCase) {
        this.stateCase = stateCase;
    }



}
