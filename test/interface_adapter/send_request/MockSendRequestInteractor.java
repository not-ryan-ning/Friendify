package interface_adapter.send_request;

import use_case.send_request.SendRequestInputBoundary;
import use_case.send_request.SendRequestInputData;

public class MockSendRequestInteractor implements SendRequestInputBoundary {
    private String currentState;

    public MockSendRequestInteractor() {
        this.currentState = "";
    }

    public String getState() {
        return this.currentState;
    }

    @Override
    public void execute(String string, SendRequestInputData inputData) {
        this.currentState = "Success";
    }
}