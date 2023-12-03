package use_case.accept_request;

import entity.User;

public class AcceptRequestInteractor implements AcceptRequestInputBoundary {
    final AcceptRequestFileUserDataAccessInterface acceptRequestFileUserDAO;
    final AcceptRequestOutputBoundary acceptRequestPresenter;

    public AcceptRequestInteractor(AcceptRequestFileUserDataAccessInterface acceptRequestFileUserDataAccessInterface,
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

        currentUser.getRequests().remove(acceptedUser.getUsername());
        currentUser.getFriends().add(acceptedUser.getUsername());

        acceptedUser.getFriends().add(currentUser.getUsername());

        acceptRequestFileUserDAO.updateUserInformation(currentUser);
        acceptRequestFileUserDAO.updateUserInformation(acceptedUser);
        AcceptRequestOutputData acceptRequestOutputData = new AcceptRequestOutputData(currentUser.getRequests());
        acceptRequestPresenter.prepareSuccessView(acceptRequestOutputData);
    }
}
