package interface_adapter.edit_spotify_handle;

import interface_adapter.ViewManagerModel;
import use_case.edit_spotify_handle.EditSpotifyHandleOutputBoundary;
import use_case.edit_spotify_handle.EditSpotifyHandleOutputData;

public class EditSpotifyHandlePresenter implements EditSpotifyHandleOutputBoundary {
    private final EditSpotifyHandleViewModel editSpotifyHandleViewModel;

    private ViewManagerModel viewManagerModel;

    public EditSpotifyHandlePresenter(ViewManagerModel viewManagerModel,
                                      EditSpotifyHandleViewModel editSpotifyHandleViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.editSpotifyHandleViewModel = editSpotifyHandleViewModel;
    }
    @Override
    public void prepareSuccessView(EditSpotifyHandleOutputData response) {

        EditSpotifyHandleState clearState = editSpotifyHandleViewModel.getState();
        clearState.setSpotifyHandle(response.getNewSpotifyHandle());
        this.editSpotifyHandleViewModel.setState(clearState);
        editSpotifyHandleViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(editSpotifyHandleViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
