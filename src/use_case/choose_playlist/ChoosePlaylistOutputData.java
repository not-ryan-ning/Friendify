package use_case.choose_playlist;

public class ChoosePlaylistOutputData {
    private final String playlistName;

    public ChoosePlaylistOutputData(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistName() {
        return playlistName;
    };
}
