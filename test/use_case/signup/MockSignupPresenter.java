package use_case.signup;

public class MockSignupPresenter implements SignupOutputBoundary {

    private String currentState;

    public MockSignupPresenter() {
        this.currentState = "";
    }
    @Override
    public void prepareSuccessView(SignupOutputData user) {
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
