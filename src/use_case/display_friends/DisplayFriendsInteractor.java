package use_case.display_friends;

import entity.User;

import java.util.ArrayList;

public class DisplayFriendsInteractor implements DisplayFriendsInputBoundary {
    final DisplayFriendsUserDataAccessInterface userDataAccessObject;
    final DisplayFriendsOutputBoundary displayFriendsPresenter;

    public DisplayFriendsInteractor(DisplayFriendsUserDataAccessInterface userDataAccessInterface,
                                    DisplayFriendsOutputBoundary displayFriendsOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.displayFriendsPresenter = displayFriendsOutputBoundary;
    }

    @Override
    public void execute(String username) {
        User user = userDataAccessObject.get(username);
        ArrayList<String> friendNames = user.getFriends();

        DisplayFriendsOutputData displayFriendsOutputData = new DisplayFriendsOutputData(friendNames);
        displayFriendsPresenter.prepareSuccessView(displayFriendsOutputData);
    }
}
