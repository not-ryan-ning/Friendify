package use_case.choose_playlist;

import entity.User;

import java.util.HashMap;

public interface ChoosePlaylistUserDataAccessInterface {
    User get(String username);

    void editPlaylist(String username, String playlistId, HashMap<String, Integer> artists);
}
