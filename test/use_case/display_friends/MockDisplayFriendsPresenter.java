package use_case.display_friends;

public class MockDisplayFriendsPresenter implements DisplayFriendsOutputBoundary {

    private String currentState;

    public MockDisplayFriendsPresenter() {
        this.currentState = "";
    }
    @Override
    public void prepareSuccessView(DisplayFriendsOutputData friends) {
        this.currentState = "Success";
    }

    public String getState() {
        return this.currentState;
    }
}
