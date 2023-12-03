package interface_adapter.display_friends;

import entity.User;
import use_case.display_friends.DisplayFriendsInputBoundary;

/**
 * Initiates operations related to displaying friends
 */
public class DisplayFriendsController {
    final DisplayFriendsInputBoundary displayFriendsInteractor;
    public DisplayFriendsController(DisplayFriendsInputBoundary displayFriendsInteractor) {
        this.displayFriendsInteractor = displayFriendsInteractor;
    }

    /**
     * Executes the operation of displaying friends for the specified username through the configured
     * @param username The username for which to display friends.
     */
    public void execute(String username) {
        displayFriendsInteractor.execute(username);
    }
}
