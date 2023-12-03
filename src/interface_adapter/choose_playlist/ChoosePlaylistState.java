package interface_adapter.choose_playlist;

/**
 * Represents the state of choosing a playlist, including the playlist name, playlist ID, and access token.
 */
public class ChoosePlaylistState {
    private String playlistName = "";
    private String playlistId = "";
    private String accessToken = "";


    public ChoosePlaylistState(ChoosePlaylistState copy) {
        playlistName = copy.playlistName;
        playlistId = copy.playlistId;
        accessToken = copy.accessToken;
    }

    public ChoosePlaylistState() {}

    public String getPlaylistName() { return playlistName; }
    public String getPlaylistId() { return playlistId; }
    public String getAccessToken() { return accessToken; }

    public void setPlaylistName(String playlistName) { this.playlistName = playlistName; }
    public void setPlaylistId(String playlistId) { this.playlistId = playlistId; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
}
