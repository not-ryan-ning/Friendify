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
    public void execute(DisplayRequestsInputData displayRequestsInputData) {
        String username = displayRequestsInputData.getUsername();

        User user = userDataAccessObject.get(username);

        DisplayRequestsOutputData displayFriendsOutputData = new DisplayRequestsOutputData(user.getFriendNames());
        displayRequestsPresenter.prepareSuccessView(displayFriendsOutputData);
    }
}

}
