package use_case.choose_playlist;

import java.util.HashMap;

public interface ChoosePlaylistPlaylistDataAccessInterface {
    void addPlaylist(String playlistId, HashMap<String, Integer> titles,
                     HashMap<String, Integer> artists, HashMap<String, Integer> genres,
                     double acousticness, double energy, double instrumentalness, double valence);
    String gerPlaylistName(String playlistId);
}
