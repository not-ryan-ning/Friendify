package use_case.accept_request;

import entity.User;

public class AcceptRequestInteractor {
    final AcceptRequestFileUserDataAccessInterface acceptRequestFileUserDAO;
    final AcceptRequestOutputBoundary acceptRequestPresenter;

    public AcceptRequestInteractor(AcceptRequestFileUserDataAccessInterface acceptRequestFileUserDataAccessInterface,
                                   AcceptRequestOutputBoundary acceptRequestOutputBoundary) {
        this.acceptRequestFileUserDAO = acceptRequestFileUserDataAccessInterface;
        this.acceptRequestPresenter = acceptRequestOutputBoundary;
    }

    @Override
    // Retrieve current and accepted Users from the database using DAO
    // Remove request from currentUser, add acceptedUser to currentUser's friend list
    // Add currentUser to acceptedUser's friend list
    // Save information about both users
    public void execute(AcceptRequestInputData acceptRequestInputData) {
        User currentUser = acceptRequestFileUserDAO.get(acceptRequestInputData.getCurrentUsername());
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
