package interface_adapter.go_back;

import use_case.go_back.GoBackInputBoundary;

public class MockGoBackInteractor implements GoBackInputBoundary {
    private String currentState;

    public MockGoBackInteractor() {
        this.currentState = "";
    }

    public String getState() {
        return this.currentState;
    }

    @Override
    public void execute() {
        this.currentState = "Success";
    }
}