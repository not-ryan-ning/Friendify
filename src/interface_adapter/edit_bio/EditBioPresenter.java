package interface_adapter.edit_bio;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_bio.EditBioViewModel;
import use_case.edit_bio.EditBioOutputBoundary;
import use_case.edit_bio.EditBioOutputData;
import use_case.edit_spotify_handle.EditSpotifyHandleOutputBoundary;
import use_case.edit_spotify_handle.EditSpotifyHandleOutputData;

public class EditBioPresenter implements EditBioOutputBoundary {
    private final EditBioViewModel editBioViewModel;

    private ViewManagerModel viewManagerModel;

    public EditBioPresenter(ViewManagerModel viewManagerModel,
                                      EditBioViewModel editBioViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.editBioViewModel = editBioViewModel;
    }
    /**
     * Prepares and updates the view for the edit bio operation.
     *
     * @param response The output data containing information about the edited bio.
     */
    @Override
    public void prepareSuccessView(EditBioOutputData response) {

        EditBioState editBioState = editBioViewModel.getState();
        editBioState.setBio(response.getNewBio());
        this.editBioViewModel.setState(editBioState);
        editBioViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(editBioViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
