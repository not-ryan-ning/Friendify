package interface_adapter.display_profile;

import interface_adapter.ViewManagerModel;
import interface_adapter.display_friend_profile.DisplayFriendProfileState;
import interface_adapter.display_common_profile.DisplayCommonProfileState;
import use_case.display_profile.DisplayProfileOutputBoundary;
import use_case.display_profile.DisplayProfileOutputData;

import interface_adapter.display_friend_profile.DisplayFriendProfileViewModel;
import interface_adapter.display_common_profile.DisplayCommonProfileViewModel;

public class DisplayProfilePresenter implements DisplayProfileOutputBoundary {

    private ViewManagerModel viewManagerModel;
    private final DisplayFriendProfileViewModel displayFriendProfileViewModel;
    private final DisplayCommonProfileViewModel displayCommonProfileViewModel;

    public DisplayProfilePresenter(DisplayFriendProfileViewModel displayFriendProfileViewModel, DisplayCommonProfileViewModel displayCommonProfileViewModel, ViewManagerModel viewManagerModel) {
        this.displayFriendProfileViewModel = displayFriendProfileViewModel;
        this.displayCommonProfileViewModel = displayCommonProfileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares and switches the view to display a friend profile based on the response data.
     *
     * @param response The output data containing information about the friend profile.
     */
    @Override
    public void prepareSuccessViewFriends(DisplayProfileOutputData response) {
        // switch to the friends-only profile of the user
        DisplayFriendProfileState displayFriendProfileState = displayFriendProfileViewModel.getState();
        this.displayFriendProfileViewModel.setState(displayFriendProfileState);
        this.displayFriendProfileViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(displayFriendProfileViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares and switches the view to display a common profile based on the response data.
     *
     * @param response The output data containing information about the common profile.
     */
    @Override
    public void prepareSuccessViewCommon(DisplayProfileOutputData response) {
        // switch to the common view profile of the user
        DisplayCommonProfileState displayCommonProfileState = displayCommonProfileViewModel.getState();
        this.displayCommonProfileViewModel.setState(displayCommonProfileState);
        this.displayCommonProfileViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(displayCommonProfileViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
