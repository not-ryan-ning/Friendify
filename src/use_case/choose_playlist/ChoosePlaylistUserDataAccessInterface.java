package use_case.choose_playlist;

import entity.Playlist;
import entity.User;

import java.util.HashMap;

public interface ChoosePlaylistUserDataAccessInterface {
    User getUser(String username);
    void editPlaylist(String username, Playlist playlist);
}
