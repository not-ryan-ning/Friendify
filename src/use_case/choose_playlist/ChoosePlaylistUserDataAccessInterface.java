package use_case.choose_playlist;

import entity.User;

import java.util.HashMap;

public interface ChoosePlaylistUserDataAccessInterface {
    void editPlaylist(String username, String playlistId, HashMap<String, Integer> artists);
}
