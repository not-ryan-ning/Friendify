package interface_adapter;

public class EditProfilePresenter implements EditProfileOutputBoundary{

    @Override
    public void prepareSuccessView(EditProfileOutputData response) {
        EditProfileState editProfileState = editProfileViewModel.getState();

        this.editProfileViewModel.setState(editProfileState);
        this.editProfileViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(editProfileViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

        // We now switches to the Logged In View after user is done editing their profile
        viewManagerModel.setActiveView(loggedinViewModel.getViewName()); // assuming there is a "profile view"
        viewManagerModel.firePropertyChanged();
    }
}
