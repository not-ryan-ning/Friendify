package use_case.login;

public class MockLoginPresenter implements LoginOutputBoundary {
    private String currentState;

    public MockLoginPresenter() {
        this.currentState = "";
    }
    @Override
    public void prepareSuccessView(LoginOutputData user) {
        this.currentState = "Success";
    }

    @Override
    public void prepareFailView(String error) {
        this.currentState = "Failure";
    }

    public String getState() {
        return this.currentState;
    }
}
