package use_case.accept_request;

import entity.User;

import java.util.ArrayList;

public class AcceptRequestInteractor implements AcceptRequestInputBoundary {
    final AcceptRequestUserDataAccessInterface acceptRequestFileUserDAO;
    final AcceptRequestOutputBoundary acceptRequestPresenter;

    public AcceptRequestInteractor(AcceptRequestUserDataAccessInterface acceptRequestFileUserDataAccessInterface,
                                   AcceptRequestOutputBoundary acceptRequestOutputBoundary) {
        this.acceptRequestFileUserDAO = acceptRequestFileUserDataAccessInterface;
        this.acceptRequestPresenter = acceptRequestOutputBoundary;
    }

    /**
     * Retrieve current and accepted Users from the database using DAO.
     * Remove request from currentUser, add acceptedUser to currentUser's friend list
     * Add currentUser to acceptedUser's friend list
     * Save information about both users
     * @param acceptRequestInputData InputData object containing current user's username and the accepted user's username
     */
    @Override

    // Retrieve current and accepted Users from the database using DAO
    // Remove request from currentUser, add acceptedUser to currentUser's friend list
    // Add currentUser to acceptedUser's friend list
    // Save information about both users
    public void execute(String currentUsername, AcceptRequestInputData acceptRequestInputData) {
        User currentUser = acceptRequestFileUserDAO.get(currentUsername);
        User acceptedUser = acceptRequestFileUserDAO.get(acceptRequestInputData.getAcceptedUsername());
        if (acceptRequestFileUserDAO.isFriend(currentUser, acceptedUser)) {
            acceptRequestPresenter.prepareFailView("You have already accepted " + acceptedUser.getUsername());
        } else {
            ArrayList<String> requests = acceptRequestFileUserDAO.acceptFriendRequest(currentUser, acceptedUser);
            ArrayList<String> currentUserFriends = acceptRequestFileUserDAO.updateCurrentUserFriends(currentUser, acceptedUser);
            ArrayList<String> acceptedUserFriends = acceptRequestFileUserDAO.updateAcceptedUserFriends(currentUser, acceptedUser);

            acceptRequestFileUserDAO.editFile(currentUsername, "requests", requests.toString());
            acceptRequestFileUserDAO.editFile(currentUsername, "friends", currentUserFriends.toString());
            acceptRequestFileUserDAO.editFile(acceptRequestInputData.getAcceptedUsername(), "friends", acceptedUserFriends.toString());
            acceptRequestPresenter.prepareSuccessView();
        }
    }
}
