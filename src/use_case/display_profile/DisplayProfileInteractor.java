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

        // if user is in friends, then they can view the profile
        if (otherUserFriends.contains(username)) {
            DisplayProfileOutputData displayProfileOutputData = new DisplayProfileOutputData();
            displayProfilePresenter.prepareSuccessView(displayProfileOutputData);
        } else {
            displayProfilePresenter.prepareFailView("You cannot view this user's profile.");
        }




    }
}
