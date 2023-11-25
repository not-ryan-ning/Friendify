package interface_adapter.display_friends;

import entity.User;
import use_case.display_friends.DisplayFriendsInputBoundary;

public class DisplayFriendsController {

    final DisplayFriendsInputBoundary displayFriendsInteractor;
    public DisplayFriendsController(DisplayFriendsInputBoundary displayFriendsInteractor) {
        this.displayFriendsInteractor = displayFriendsInteractor;
    }

    public void execute() {
        displayFriendsInteractor.execute();
    }
}
