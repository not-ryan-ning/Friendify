package interface_adapter.choose_playlist;

import interface_adapter.ViewManagerModel;
import use_case.choose_playlist.ChoosePlaylistOutputBoundary;
import use_case.choose_playlist.ChoosePlaylistOutputData;

/**
 * Handles outputs related to choosing a playlist and updating the corresponding view models.
 */
public class ChoosePlaylistPresenter implements ChoosePlaylistOutputBoundary {
    private final ChoosePlaylistViewModel choosePlaylistViewModel;
    private ViewManagerModel viewManagerModel;

    public ChoosePlaylistPresenter(ViewManagerModel viewManagerModel,
                                   ChoosePlaylistViewModel choosePlaylistViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.choosePlaylistViewModel = choosePlaylistViewModel;
    }

    /**
     * Prepares and updates the success view based on the output data from choosing a playlist.
     *
     * @param response The output data containing the chosen playlist's name.
     */
    @Override
    public void prepareSuccessView(ChoosePlaylistOutputData response) {
        ChoosePlaylistState choosePlaylistState = choosePlaylistViewModel.getState();
        choosePlaylistState.setPlaylistName(response.getPlaylistName());
        this.choosePlaylistViewModel.setState(choosePlaylistState);
        this.choosePlaylistViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(choosePlaylistViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

}
