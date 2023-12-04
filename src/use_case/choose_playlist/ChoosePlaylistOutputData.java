package use_case.choose_playlist;

import java.util.ArrayList;

public class ChoosePlaylistOutputData {
    private final String playlistName;
    private final ArrayList<String> topThreeArtists;

    public ChoosePlaylistOutputData(String playlistName, ArrayList<String> topThreeArtists) {
        this.playlistName = playlistName;
        this.topThreeArtists = topThreeArtists;
    }

    public String getPlaylistName() {
        return playlistName;
    };

    public ArrayList<String> getTopThreeArtists() {
        return topThreeArtists;
    }
}
