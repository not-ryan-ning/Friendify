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

    @Override
    public void execute(User user) {
        DisplayRequestsOutputData displayRequestsOutputData = new DisplayRequestsOutputData(user.getRequests());
        displayRequestsPresenter.prepareSuccessView(displayRequestsOutputData);
    }
}

