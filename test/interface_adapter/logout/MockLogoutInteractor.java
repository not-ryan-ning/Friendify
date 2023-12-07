package interface_adapter.logout;

import use_case.logout.LogoutInputBoundary;

public class MockLogoutInteractor implements LogoutInputBoundary {
    private String currentState;

    public MockLogoutInteractor() {
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