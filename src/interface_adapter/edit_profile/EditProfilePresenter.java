package interface_adapter.edit_profile;

import interface_adapter.ViewManagerModel;
import use_case.edit_profile.EditProfileOutputBoundary;

public class EditProfilePresenter implements EditProfileOutputBoundary{
    private final EditProfileViewModel editProfileViewModel;
    private ViewManagerModel viewManagerModel;

    public EditProfilePresenter(ViewManagerModel viewManagerModel,
                                EditProfileViewModel editProfileViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.editProfileViewModel = editProfileViewModel;
    }

    @Override
    public void prepareSuccessView() {
        EditProfileState editProfileState = editProfileViewModel.getState();
        this.editProfileViewModel.setState(editProfileState);
        this.editProfileViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(editProfileViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
        // We now switches to the Logged In View after user is done editing their profile
        // viewManagerModel.setActiveView(loggedinViewModel.getViewName()); // assuming there is a "profile view"
        // viewManagerModel.firePropertyChanged();
    }
}