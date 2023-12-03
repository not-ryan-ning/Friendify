package use_case.display_requests;

import entity.User;
public class DisplayRequestsInteractor implements DisplayRequestsInputBoundary {
    final DisplayRequestsUserDataAccessInterface userDataAccessObject;
    final DisplayRequestsOutputBoundary displayRequestsPresenter;

    public DisplayRequestsInteractor(DisplayRequestsUserDataAccessInterface userDataAccessInterface,
                                    DisplayRequestsOutputBoundary displayFriendsOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.displayRequestsPresenter = displayFriendsOutputBoundary;
    }

    /**
     * Gets the list of friend requests for the given username and displays it by calling prepareSuccessView
     *
     * @param username The username of the current user trying to see their requests
     */
    @Override
    public void execute(String username) {
        User user = userDataAccessObject.get(username);
        DisplayRequestsOutputData displayRequestsOutputData = new DisplayRequestsOutputData(user.getRequests());
        displayRequestsPresenter.prepareSuccessView(displayRequestsOutputData);
    }
}

