package use_case.choose_playlist;

import java.util.ArrayList;
import java.util.HashMap;

public interface ChoosePlaylistSpotifyAPIDataAccessInterface {
    ArrayList<Object> getPlaylistInfo(String username, String playlistId, String access_token);
}
