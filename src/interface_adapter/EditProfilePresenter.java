package interface_adapter;

public class EditProfilePresenter implements EditProfileOutputBoundary{

    @Override
    public void prepareSuccessView(EditProfileOutputData response) {
        EditProfileState editProfileState = editProfileViewModel.getState();

        this.editProfileViewModel.setState(editProfileState);
        this.editProfileViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(editProfileViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

        // We now switch back to the Profile View after user is done editing their profile
        viewManagerModel.setActiveView(profileViewModel.getViewName()); // assuming there is a "profile view"
        viewManagerModel.firePropertyChanged();
    }
}
