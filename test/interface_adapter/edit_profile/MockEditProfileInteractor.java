package interface_adapter.edit_profile;

import use_case.edit_profile.EditProfileInputBoundary;

public class MockEditProfileInteractor implements EditProfileInputBoundary {
    private String currentState;

    public MockEditProfileInteractor() {
        this.currentState = "";
    }

    public String getState() {
        return this.currentState;
    }

    @Override
    public void execute() {
        this.currentState = "Success";
    }
}