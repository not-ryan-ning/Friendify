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

    @Override
    public void execute(DisplayPlaylistsInputData displayPlaylistsInputData) {
        String accessToken = displayPlaylistsInputData.getAccessToken();
        HashMap<String, String> playlistIdName = spotifyAPIDataAccessObject.getPlaylists(accessToken);
        DisplayPlaylistsOutputData displayPlaylistsOutputData = new DisplayPlaylistsOutputData(playlistIdName);
        displayPlaylistsPresenter.prepareSuccessView(displayPlaylistsOutputData);
    }
}
