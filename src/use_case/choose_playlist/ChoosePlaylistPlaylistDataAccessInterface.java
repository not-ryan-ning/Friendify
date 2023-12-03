package use_case.choose_playlist;

import entity.Playlist;

import java.util.HashMap;

public interface ChoosePlaylistPlaylistDataAccessInterface {
    void storePlaylist(Playlist playlist);
    boolean isIn(String playlistId);
    Playlist getPlaylist(String playlistId);
}
