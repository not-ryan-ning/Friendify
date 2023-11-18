package use_case.display_friends;

import entity.User;

public class DisplayFriendsInteractor implements DisplayFriendsInputBoundary {
    final DisplayFriendsUserDataAccessInterface userDataAccessObject;
    final DisplayFriendsOutputBoundary displayFriendsPresenter;

    public DisplayFriendsInteractor(DisplayFriendsUserDataAccessInterface userDataAccessInterface,
                                    DisplayFriendsOutputBoundary displayFriendsOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.displayFriendsPresenter = displayFriendsOutputBoundary;
    }

    @Override
    public void execute(DisplayFriendsInputData displayFriendsInputData) {
        String username = displayFriendsInputData.getUsername();

        User user = userDataAccessObject.get(username);

        DisplayFriendsOutputData displayFriendsOutputData = new DisplayFriendsOutputData(user.getFriendNames());
        displayFriendsPresenter.prepareSuccessView(displayFriendsOutputData);
    }
}
