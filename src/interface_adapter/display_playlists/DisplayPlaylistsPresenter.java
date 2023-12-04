package interface_adapter.display_playlists;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import use_case.display_playlists.DisplayPlaylistsOutputBoundary;
import use_case.display_playlists.DisplayPlaylistsOutputData;
import use_case.login.LoginOutputData;

/**
 * Handles outputs related to displaying playlists and updating the corresponding view models.
 */
public class DisplayPlaylistsPresenter implements DisplayPlaylistsOutputBoundary {

    private final DisplayPlaylistsViewModel displayPlaylistsViewModel;
    private ViewManagerModel viewManagerModel;

    public DisplayPlaylistsPresenter(ViewManagerModel viewManagerModel,
                                     DisplayPlaylistsViewModel displayPlaylistsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.displayPlaylistsViewModel = displayPlaylistsViewModel;
    }

    @Override
    public void prepareSuccessView(DisplayPlaylistsOutputData response) {
        DisplayPlaylistsState displayPlaylistsState = displayPlaylistsViewModel.getState();
        displayPlaylistsState.setPlaylistIdName(response.getPlaylistIdName());
        this.displayPlaylistsViewModel.setState(displayPlaylistsState);
        this.displayPlaylistsViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(displayPlaylistsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
