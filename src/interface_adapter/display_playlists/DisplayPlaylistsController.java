package interface_adapter.display_playlists;

import use_case.display_playlists.DisplayPlaylistsInputBoundary;

public class DisplayPlaylistsController {
    final DisplayPlaylistsInputBoundary displayPlaylistsInteractor;

    public DisplayPlaylistsController(DisplayPlaylistsInputBoundary displayPlaylistsInteractor) {
        this.displayPlaylistsInteractor = displayPlaylistsInteractor;
    }

    public void execute() {
        displayPlaylistsInteractor.execute();
    }

}
