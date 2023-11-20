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
    public void execute(User user) {
        ArrayList<String> friendNames = user.getFriendNames();

        DisplayFriendsOutputData displayFriendsOutputData = new DisplayFriendsOutputData(friendNames);
        displayFriendsPresenter.prepareSuccessView(displayFriendsOutputData);
    }
}
