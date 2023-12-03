package interface_adapter.edit_profile;

import interface_adapter.ViewManagerModel;
import use_case.edit_profile.EditProfileOutputBoundary;

/**
 * Prepares and updates view for corresponding operation.
 */
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
    }
}
