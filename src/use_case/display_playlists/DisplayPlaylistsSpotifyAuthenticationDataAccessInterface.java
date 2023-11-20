package use_case.display_playlists;

import java.util.HashMap;

public interface DisplayPlaylistsSpotifyAuthenticationDataAccessInterface {
    String getRequestUserAuthorizationUrl();
    String getAccessToken(String authorizationCode);
}
