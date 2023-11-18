package use_case.choose_playlist;

public class ChoosePlaylistInputData {

    final private String username;
    final private String playlistId;
    final private String accessToken;

    public ChoosePlaylistInputData(String username, String playlistId, String accessToken) {
        this.username = username;
        this.playlistId = playlistId;
        this.accessToken = accessToken;

    }

    String getUsername() { return username; }
    String getPlaylistId() { return playlistId; }
    String getAccessToken() { return accessToken; }
}
