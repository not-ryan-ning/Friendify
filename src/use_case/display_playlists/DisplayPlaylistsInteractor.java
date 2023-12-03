package use_case.display_playlists;

import java.util.HashMap;

public class DisplayPlaylistsInteractor implements DisplayPlaylistsInputBoundary {
    final DisplayPlaylistsSpotifyAPIDataAccessInterface spotifyAPIDataAccessObject;
    final DisplayPlaylistsOutputBoundary displayPlaylistsPresenter;

    public DisplayPlaylistsInteractor(DisplayPlaylistsSpotifyAPIDataAccessInterface spotifyAPIDataAccessObject,
                                      DisplayPlaylistsOutputBoundary displayPlaylistsOutputBoundary) {
        this.spotifyAPIDataAccessObject = spotifyAPIDataAccessObject;
        this.displayPlaylistsPresenter = displayPlaylistsOutputBoundary;
    }

    /**
     * Retrieves the user's playlists from the Spotify API data access
     * object using the access token given in displayPlaylistsInputData. The retrieved playlist information is
     * stored in a DisplayPlaylistsOutputData object, which is passed to the display playlists presenter.
     * @param displayPlaylistsInputData The input data containing access token for getting playlists.
     */
    @Override
    public void execute(DisplayPlaylistsInputData displayPlaylistsInputData) {
        String accessToken = displayPlaylistsInputData.getAccessToken();
        HashMap<String, String> playlistIdName = spotifyAPIDataAccessObject.getPlaylists(accessToken);
        DisplayPlaylistsOutputData displayPlaylistsOutputData = new DisplayPlaylistsOutputData(playlistIdName);
        displayPlaylistsPresenter.prepareSuccessView(displayPlaylistsOutputData);
    }
}
