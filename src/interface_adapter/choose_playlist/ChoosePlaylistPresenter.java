package interface_adapter.choose_playlist;

import interface_adapter.ViewManagerModel;
import use_case.choose_playlist.ChoosePlaylistOutputBoundary;
import use_case.choose_playlist.ChoosePlaylistOutputData;

public class ChoosePlaylistPresenter implements ChoosePlaylistOutputBoundary {
    private final ChoosePlaylistViewModel choosePlaylistViewModel;
    private ViewManagerModel viewManagerModel;

    public ChoosePlaylistPresenter(ViewManagerModel viewManagerModel,
                                   ChoosePlaylistViewModel choosePlaylistViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.choosePlaylistViewModel = choosePlaylistViewModel;
    }

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
