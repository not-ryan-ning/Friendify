package interface_adapter.accept_request;

import use_case.accept_request.AcceptRequestInputBoundary;
import use_case.accept_request.AcceptRequestInputData;

public class MockAcceptRequestInteractor implements AcceptRequestInputBoundary {
    private String currentState;
    public void MockAcceptRequestinteractor() {
        this.currentState = "";
    }
    @Override
    public void execute(String string, AcceptRequestInputData inputData) {
        this.currentState = "success";
    }

    public String getState() {
        return currentState;
    }
}
