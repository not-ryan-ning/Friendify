package use_case.edit_profile;

public class MockEditProfilePresenter implements EditProfileOutputBoundary {
    private String currentState;

    public MockEditProfilePresenter() {
        this.currentState = "";
    }
    @Override
    public void prepareSuccessView() {
        this.currentState = "Success";
    }

    public String getState() {
        return this.currentState;
    }
}
