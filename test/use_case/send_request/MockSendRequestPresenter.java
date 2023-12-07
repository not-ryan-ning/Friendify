package use_case.send_request;

public class MockSendRequestPresenter implements SendRequestOutputBoundary {
    private String currentState;

    public MockSendRequestPresenter() {
        this.currentState = "";
    }
    @Override
    public void prepareSuccessView(SendRequestOutputData user) {
        this.currentState = "Success";
    }

    @Override
    public void prepareFailView(String error) {
        this.currentState = "Failure";
    }

    public String getState() {
        return currentState;
    }
}
