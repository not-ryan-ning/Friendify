package interface_adapter.choose_playlist;

import use_case.choose_playlist.ChoosePlaylistInputBoundary;
import use_case.choose_playlist.ChoosePlaylistInputData;

public class MockChoosePlaylistInteractor implements ChoosePlaylistInputBoundary {

    private String currentState;

    public MockChoosePlaylistInteractor() {
        this.currentState = "";
    }

    public String getState() {
        return currentState;
    }

    @Override
    public void execute(String username, ChoosePlaylistInputData choosePlaylistInputData) {
        this.currentState = "Success";
    }
}
