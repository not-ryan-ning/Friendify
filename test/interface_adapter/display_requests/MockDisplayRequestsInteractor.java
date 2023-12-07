package interface_adapter.display_requests;

import use_case.display_requests.DisplayRequestsInputBoundary;

public class MockDisplayRequestsInteractor implements DisplayRequestsInputBoundary {
    private String currentState;

    public MockDisplayRequestsInteractor() {
        this.currentState = "";
    }

    public String getState() {
        return this.currentState;
    }

    @Override
    public void execute(String string) {
        this.currentState = "Success";
    }
}