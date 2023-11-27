package interface_adapter.display_playlists;

import java.util.HashMap;

public class DisplayPlaylistsState {
    private HashMap<String, String> playlistIdName;
    private String accessToken;

    public DisplayPlaylistsState(DisplayPlaylistsState copy) {
        playlistIdName = copy.playlistIdName;
        accessToken = copy.accessToken;
    }

    public DisplayPlaylistsState() {}

    public HashMap<String, String> getPlaylistIdName() { return playlistIdName; }

    public String getAccessToken() { return accessToken; }
    public void setPlaylistIdName(HashMap<String, String> playlistIdName) {
        this.playlistIdName = playlistIdName;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
