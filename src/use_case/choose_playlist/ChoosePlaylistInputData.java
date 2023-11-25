package use_case.choose_playlist;

public class ChoosePlaylistInputData {
    final private String playlistId;
    final private String accessToken;

    public ChoosePlaylistInputData(String playlistId, String accessToken) {
        this.playlistId = playlistId;
        this.accessToken = accessToken;

    }

    String getPlaylistId() { return playlistId; }
    String getAccessToken() { return accessToken; }
}
