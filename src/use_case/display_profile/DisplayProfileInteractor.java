package use_case.display_profile;

import entity.Profile;
import entity.User;
import interface_adapter.display_profile.DisplayProfileViewModel;


public class DisplayProfileInteractor implements DisplayProfileInputBoundary {
    final DisplayProfileUserDataAccessInterface userDataAccessObject;
    final DisplayProfileOutputBoundary displayProfilePresenter;
    final DisplayProfileViewModel displayProfileViewModel;

    public DisplayProfileInteractor(DisplayProfileUserDataAccessInterface userDataAccessInterface, DisplayProfileOutputBoundary displayProfileOutputBoundary
    , DisplayProfileViewModel displayProfileViewModel) {
        this.userDataAccessObject = userDataAccessInterface;
        this.displayProfilePresenter = displayProfileOutputBoundary;
        this.displayProfileViewModel = displayProfileViewModel;
    }

    /**
     * Executes the display profile use case based on the provided input data. If the user is a friend, the
     * friend profile is displayed; otherwise, the common profile is shown by calling the appropriate prepareSuccessView methods
     * @param displayProfileInputData The input data containing the username of the profile to be displayed.
     */
    @Override
    public void execute(String username, DisplayProfileInputData displayProfileInputData) {
        String otherUsername = displayProfileInputData.getOtherUsername();

        User user = userDataAccessObject.get(username);
        User otherUser = userDataAccessObject.get(otherUsername);
        Profile profile = otherUser.getProfile();

        DisplayProfileOutputData displayProfileOutputData = new DisplayProfileOutputData(otherUser.getUsername(), profile.getBio(),
                profile.getTopThreeArtists(), profile.getSpotifyHandle());

        // if user is a friend, then they can view the friends-only user profile:
        if (user.getFriends().contains(otherUsername)) {
            displayProfilePresenter.prepareSuccessViewFriends(displayProfileOutputData);
        }
        // else the user can only see the common user profile:
        else {
            displayProfilePresenter.prepareSuccessViewCommon(displayProfileOutputData);
        }
    }
}
