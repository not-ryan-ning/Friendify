package use_case.display_playlists;

import java.util.HashMap;

public interface DisplayPlaylistsSpotifyAPIDataAccessInterface {
    // get a map that maps playlist id to playlist name
    HashMap<String, String> getPlaylists(String accessToken);
}
