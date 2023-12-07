package interface_adapter.display_friends;

import use_case.display_friends.DisplayFriendsInputBoundary;

public class MockDisplayFriendsInteractor implements DisplayFriendsInputBoundary {
    private String currentState;

    public MockDisplayFriendsInteractor() {
        this.currentState = "";
    }

    public String getState() {
        return this.currentState;
    }

    @Override
    public void execute(String username) {
        this.currentState = "Success";
    }
}
