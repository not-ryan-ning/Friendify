package use_case.display_playlists;

import java.util.HashMap;

public class DisplayPlaylistsOutputData {
    private final HashMap<String, String> playlistIdName;

    public DisplayPlaylistsOutputData(HashMap<String, String> playlistIdName) {
        this.playlistIdName = playlistIdName;
    }

    public HashMap<String, String> getPlaylistIdName() {
        return playlistIdName;
    }
}
