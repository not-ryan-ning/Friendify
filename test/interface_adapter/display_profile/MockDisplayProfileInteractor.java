package interface_adapter.display_profile;

import use_case.display_profile.DisplayProfileInputBoundary;
import use_case.display_profile.DisplayProfileInputData;

public class MockDisplayProfileInteractor implements DisplayProfileInputBoundary {
    private String currentState;

    public MockDisplayProfileInteractor() {
        this.currentState = "";
    }

    public String getState() {
        return this.currentState;
    }

    @Override
    public void execute(String accessToken, DisplayProfileInputData inputData) {
        this.currentState = "Success";
    }
}
