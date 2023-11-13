package use_case.editProfile;

import java.util.HashMap;

public interface EditProfileSpotifyAPIDataAccessInterface {
    String getRequestUserAuthorizationUrl();
    String getAccessToken(String authorizationCode);

    HashMap<String, String> getPlaylists(String access_token);
    void storePlaylistInfo(String username, String playlistId, String access_token);
}