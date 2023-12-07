package use_case.display_requests;

public class MockDisplayRequestsPresenter implements DisplayRequestsOutputBoundary {
    private String currentState;

    public MockDisplayRequestsPresenter() {
        this.currentState = "";
    }

    @Override
    public void prepareSuccessView(DisplayRequestsOutputData requests) {
        this.currentState = "Success";;
    }

    public String getState() {
        return currentState;
    }
}
