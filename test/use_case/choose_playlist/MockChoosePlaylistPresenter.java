package use_case.choose_playlist;

public class MockChoosePlaylistPresenter implements ChoosePlaylistOutputBoundary {

    private String currentState;
    private String playlistName;
    @Override
    public void prepareSuccessView(ChoosePlaylistOutputData chosenPlaylist) {
        this.currentState = "Success";
        this.playlistName = "1";
    }

    public String getState() {
        return this.currentState;
    }

    public String getPlaylistName() {
        return this.playlistName;
    }
}
