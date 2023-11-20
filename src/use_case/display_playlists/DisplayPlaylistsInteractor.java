package use_case.display_playlists;

import java.util.HashMap;

public class DisplayPlaylistsInteractor implements DisplayPlaylistsInputBoundary {
    final DisplayPlaylistsSpotifyAuthenticationDataAccessInterface spotifyAuthenticationDataAccessObject;
    final DisplayPlaylistsSpotifyAPIDataAccessInterface spotifyAPIDataAccessObject;
    final DisplayPlaylistsOutputBoundary displayPlaylistsPresenter;

    public DisplayPlaylistsInteractor(DisplayPlaylistsSpotifyAuthenticationDataAccessInterface spotifyAuthenticationDataAccessObject,
                                      DisplayPlaylistsSpotifyAPIDataAccessInterface spotifyAPIDataAccessObject,
                                      DisplayPlaylistsOutputBoundary displayPlaylistsOutputBoundary) {
        this.spotifyAuthenticationDataAccessObject = spotifyAuthenticationDataAccessObject;
        this.spotifyAPIDataAccessObject = spotifyAPIDataAccessObject;
        this.displayPlaylistsPresenter = displayPlaylistsOutputBoundary;
    }

    @Override
    public void execute() {
        // accessToken can return null if the authentication process fails
        String accessToken = spotifyAuthenticationDataAccessObject.getAccessToken();
        if (accessToken != null) {
            HashMap<String, String> playlistIdName = spotifyAPIDataAccessObject.getPlaylists(accessToken);
            DisplayPlaylistsOutputData displayPlaylistsOutputData = new DisplayPlaylistsOutputData(playlistIdName);
            displayPlaylistsPresenter.prepareSuccessView(displayPlaylistsOutputData);
        } else {
            displayPlaylistsPresenter.prepareFailView("Unable to complete authentication process successfully.");
        }
    }
}
