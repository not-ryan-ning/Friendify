package use_case.display_profile;

import entity.User;

import java.util.ArrayList;

public class DisplayProfileInteractor implements DisplayProfileInputBoundary {
    final DisplayProfileUserDataAccessInterface userDataAccessObject;
    final DisplayProfileOutputBoundary displayProfilePresenter;

    public DisplayProfileInteractor(DisplayProfileUserDataAccessInterface userDataAccessInterface, DisplayProfileOutputBoundary displayProfileOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.displayProfilePresenter = displayProfileOutputBoundary;
    }

    @Override
    public void execute(DisplayProfileInputData displayProfileInputData) {
        String username = displayProfileInputData.getUsername();
        String otherUsername = displayProfileInputData.getUsername();

        User user = userDataAccessObject.get(otherUsername);
        ArrayList<String> otherUserFriends = user.getFriendNames();

        DisplayProfileOutputData displayProfileOutputData = new DisplayProfileOutputData();
        // if user is a friend, then they can view the friends-only user profile:
        if (otherUserFriends.contains(username)) {
            displayProfilePresenter.prepareSuccessViewFriends(displayProfileOutputData);
        }
        // else the user can only see the common user profile:
        else {
            displayProfilePresenter.prepareSuccessViewCommon(displayProfileOutputData);
            //displayProfilePresenter.prepareFailView("You cannot view this user's profile.");
        }




    }
}
