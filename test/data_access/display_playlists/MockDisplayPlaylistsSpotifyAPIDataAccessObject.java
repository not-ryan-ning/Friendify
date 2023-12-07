package data_access.display_playlists;

import use_case.display_playlists.DisplayPlaylistsSpotifyAPIDataAccessInterface;

import java.util.HashMap;

public class MockDisplayPlaylistsSpotifyAPIDataAccessObject implements DisplayPlaylistsSpotifyAPIDataAccessInterface {
    @Override
    public HashMap<String, String> getPlaylists(String accessToken) {
        return null;
    }
}
