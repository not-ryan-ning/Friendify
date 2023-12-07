package use_case.display_profile;

public class MockDisplayProfilePresenter implements DisplayProfileOutputBoundary {
    private String currentState;

    public MockDisplayProfilePresenter() {
        this.currentState = "";
    }
    @Override
    public void prepareSuccessViewFriends(DisplayProfileOutputData friendUserInfo) {
        this.currentState = "Friends";
    }

    @Override
    public void prepareSuccessViewCommon(DisplayProfileOutputData commonUserInfo) {
        this.currentState = "Common";
    }

    public String getState() {
        return this.currentState;
    }
}
