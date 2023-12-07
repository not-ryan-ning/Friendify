package interface_adapter.display_playlists;

import use_case.display_playlists.DisplayPlaylistsInputBoundary;
import use_case.display_playlists.DisplayPlaylistsInputData;

public class MockDisplayPlaylistsInteractor implements DisplayPlaylistsInputBoundary {
    private String currentState;

    public MockDisplayPlaylistsInteractor() {
        this.currentState = "";
    }

    public String getState() {
        return this.currentState;
    }

    @Override
    public void execute(DisplayPlaylistsInputData inputData) {
        this.currentState = "Success";
    }
}
