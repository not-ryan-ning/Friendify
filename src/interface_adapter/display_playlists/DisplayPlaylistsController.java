package interface_adapter.display_playlists;

import use_case.display_playlists.DisplayPlaylistsInputBoundary;
import use_case.display_playlists.DisplayPlaylistsInputData;

/**
 * Initiates operations related to displaying playlists
 */
public class DisplayPlaylistsController {
    final DisplayPlaylistsInputBoundary displayPlaylistsInteractor;

    public DisplayPlaylistsController(DisplayPlaylistsInputBoundary displayPlaylistsInteractor) {
        this.displayPlaylistsInteractor = displayPlaylistsInteractor;
    }

    public void execute(String accessToken) {
        DisplayPlaylistsInputData displayPlaylistsInputData = new DisplayPlaylistsInputData(accessToken);
        displayPlaylistsInteractor.execute(displayPlaylistsInputData);
    }

}
