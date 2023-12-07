package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

public class MockSignupInteractor implements SignupInputBoundary {
    private String currentState;

    public MockSignupInteractor() {
        this.currentState = "";
    }

    public String getState() {
        return this.currentState;
    }

    @Override
    public void execute(SignupInputData inputData) {
        this.currentState = "Success";
    }
}