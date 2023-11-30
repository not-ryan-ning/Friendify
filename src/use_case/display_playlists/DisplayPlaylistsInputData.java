package use_case.display_playlists;

public class DisplayPlaylistsInputData {
    final private String accessToken;

    public DisplayPlaylistsInputData(String accessToken) {
        this.accessToken = accessToken;
    }
    String getAccessToken() { return accessToken; }
}
