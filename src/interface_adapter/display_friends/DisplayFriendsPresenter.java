package interface_adapter.display_friends;

import interface_adapter.ViewManagerModel;
import use_case.display_friends.DisplayFriendsOutputBoundary;
import use_case.display_friends.DisplayFriendsOutputData;

public class DisplayFriendsPresenter implements DisplayFriendsOutputBoundary {

    private final DisplayFriendsViewModel displayFriendsViewModel;

    private ViewManagerModel viewManagerModel;

    public DisplayFriendsPresenter(ViewManagerModel viewManagerModel,
                                   DisplayFriendsViewModel displayFriendsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.displayFriendsViewModel = displayFriendsViewModel;
    }

    @Override
    public void prepareSuccessView(DisplayFriendsOutputData response) {
        DisplayFriendsState displayFriendsState = displayFriendsViewModel.getState();
        displayFriendsState.setFriends(response.getFriendNames());
        displayFriendsViewModel.setState(displayFriendsState);
        displayFriendsViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(displayFriendsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
