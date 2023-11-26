package interface_adapter.display_profile;

import use_case.display_profile.DisplayProfileInputData;
import use_case.display_profile.DisplayProfileOutputBoundary;
import use_case.display_profile.DisplayProfileOutputData;

public class DisplayProfilePresenter implements DisplayProfileOutputBoundary {
    private final DisplayProfileViewModel displayProfileViewModel;


    private ViewManagerModel viewManagerModel;

    public DisplayProfilePresenter(DisplayProfileViewModel displayProfileViewModel, ViewManagerModel viewManagerModel) {
        this.displayProfileViewModel = displayProfileViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessView(DisplayProfileOutputData response) {
        // switch to the friends-only profile of the user
        DisplayProfileState displayProfileState = displayProfileViewModel.getState();
        displayProfileState.setFriendProfile(response.getFriendProfile()); // firend profile will be like loggedin form ca
        this.displayProfileViewModel.setState(displayProfileState);
        this.displayProfileViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView();
    }
    public void prepareSuccessViewCommon(DisplayProfileOutputData user) {
        // switch to the common view profile of the user
    }
}
