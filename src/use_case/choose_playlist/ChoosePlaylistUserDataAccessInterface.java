package use_case.choose_playlist;

import entity.Playlist;
import entity.User;

import java.util.HashMap;

public interface ChoosePlaylistUserDataAccessInterface {
    void editPlaylist(String username, Playlist playlist);
}
