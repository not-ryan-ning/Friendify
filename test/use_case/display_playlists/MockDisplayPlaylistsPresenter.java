package use_case.display_playlists;

public class MockDisplayPlaylistsPresenter implements DisplayPlaylistsOutputBoundary {
    private String currentState;

    public MockDisplayPlaylistsPresenter() {
        this.currentState = "";
    }
    @Override
    public void prepareSuccessView(DisplayPlaylistsOutputData playlistIdName) {
        this.currentState = "Success";
    }

    public String getState() {
        return currentState;
    }
}
