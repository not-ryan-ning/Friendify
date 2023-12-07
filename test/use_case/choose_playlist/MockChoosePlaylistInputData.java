package use_case.choose_playlist;

public class MockChoosePlaylistInputData extends ChoosePlaylistInputData {

    final private String playlistId;
    final private String playlistName;
    final private String accessToken;

    public MockChoosePlaylistInputData(String playlistId, String playlistName, String accessToken) {
        super(playlistId, playlistName, accessToken);
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.accessToken = accessToken;
    }

    @Override
    String getPlaylistId() { return playlistId; }

    @Override
    String getPlaylistName() { return playlistName; }

    @Override
    String getAccessToken() { return accessToken; }

}
