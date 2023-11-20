package use_case.choose_playlist;

import entity.Playlist;

import java.util.HashMap;

public interface ChoosePlaylistPlaylistDataAccessInterface {
    void storePlaylist(Playlist playlist);
    String getPlaylistName(String playlistId);
}
