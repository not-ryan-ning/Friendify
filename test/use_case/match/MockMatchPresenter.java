package use_case.match;

public class MockMatchPresenter implements MatchOutputBoundary {
    private String currentState;

    public MockMatchPresenter() {
        this.currentState = "";
    }
    @Override
    public void prepareSuccessView(MatchOutputData response) {
        this.currentState = "Success";
    }

    public String getState() {
        return currentState;
    }
}
