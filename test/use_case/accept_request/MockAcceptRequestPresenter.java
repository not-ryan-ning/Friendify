package use_case.accept_request;

public class MockAcceptRequestPresenter implements AcceptRequestOutputBoundary {
    private String currentState;

    public MockAcceptRequestPresenter() {
        this.currentState = "";
    }

    @Override
    public void prepareSuccessView() {
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
