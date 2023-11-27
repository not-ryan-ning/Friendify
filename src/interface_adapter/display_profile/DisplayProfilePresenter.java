package interface_adapter.display_profile;

import interface_adapter.ViewManagerModel;
import interface_adapter.display_friend_profile.DisplayFriendProfileState;
import use_case.display_profile.DisplayProfileOutputBoundary;
import use_case.display_profile.DisplayProfileOutputData;

public class DisplayProfilePresenter implements DisplayProfileOutputBoundary {
    private final DisplayProfileViewModel displayProfileViewModel;


    private ViewManagerModel viewManagerModel;
    private final DisplayFriendProfileViewModel displayFriendProfileViewModel;
    private final DisplayCommonProfileViewModel displayCommonProfileViewModel;

    public DisplayProfilePresenter(DisplayProfileViewModel displayProfileViewModel, ViewManagerModel viewManagerModel) {
        this.displayProfileViewModel = displayProfileViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessViewFriends(DisplayProfileOutputData response) {
        // switch to the friends-only profile of the user
        DisplayFriendProfileState displayFriendProfileState = displayFriendProfileViewModel.getState();
        displayProfileState.setFriendProfile(response.getFriendProfile()); // friend profile will be like loggedin form ca
        this.displayFriendProfileViewModel.setState(displayFriendProfileViewModel);
        this.displayFriendProfileViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(displayFriendProfileViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareSuccessViewCommon(DisplayProfileOutputData user) {
        // switch to the common view profile of the user
        DisplayCommonProfileState displayCommonProfileState = displayCommonProfileViewModel.getState();
        displayCommonProfileState.setCommonProfile(response.getCommonProfile()); // firend profile will be like loggedin form ca
        this.displayCommonProfileViewModel.setState(displayCommonProfileState);
        this.displayCommonProfileViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(displayCommonProfileViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
