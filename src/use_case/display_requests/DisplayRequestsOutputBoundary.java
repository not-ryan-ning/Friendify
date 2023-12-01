package use_case.display_requests;

import use_case.display_friends.DisplayFriendsOutputData;

public interface DisplayRequestsOutputBoundary {
    void prepareSuccessView(DisplayRequestsOutputData requests);
}
