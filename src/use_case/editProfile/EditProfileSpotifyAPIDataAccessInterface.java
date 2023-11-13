package use_case.editProfile;

import java.util.ArrayList;
import java.util.HashMap;

public interface SpotifyAPIDataAccessInterface {
    String getRequestUserAuthorizationUrl();
    String getAccessToken(String authorizationCode);

    HashMap<String, String> getPlaylists(String access_token);
    void storePlaylistInfo(String username, String playlistId, String access_token);
}