package use_case.choose_playlist;

public class ChoosePlaylistInputData {
    final private String playlistId;
    final private String playlistName;
    final private String accessToken;

    public ChoosePlaylistInputData(String playlistId, String playlistName, String accessToken) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.accessToken = accessToken;
    }

    String getPlaylistId() { return playlistId; }
    String getPlaylistName() { return playlistName; }
    String getAccessToken() { return accessToken; }
}
