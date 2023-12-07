package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

public class MockLoginInteractor implements LoginInputBoundary {
    private String currentState;

    public MockLoginInteractor() {
        this.currentState = "";
    }

    public String getState() {
        return this.currentState;
    }

    @Override
    public void execute(LoginInputData inputData) {
        this.currentState = "Success";
    }
}