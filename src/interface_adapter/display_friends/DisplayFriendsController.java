package interface_adapter.display_friends;

import use_case.display_friends.DisplayFriendsInputBoundary;
import use_case.display_friends.DisplayFriendsInputData;

public class DisplayFriendsController {

    final DisplayFriendsInputBoundary displayFriendsInteractor;
    public DisplayFriendsController(DisplayFriendsInputBoundary displayFriendsInteractor) {
        this.displayFriendsInteractor = displayFriendsInteractor;
    }

    public void execute(String username) {
        DisplayFriendsInputData displayFriendsInputData = new DisplayFriendsInputData(username);

        displayFriendsInteractor.execute(displayFriendsInputData);
    }
}
