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
    public void execute(String username) {
        User user = userDataAccessObject.get(username);
        DisplayRequestsOutputData displayRequestsOutputData = new DisplayRequestsOutputData(user.getRequests());
        System.out.println(user.getRequests());
        displayRequestsPresenter.prepareSuccessView(displayRequestsOutputData);
    }
}

