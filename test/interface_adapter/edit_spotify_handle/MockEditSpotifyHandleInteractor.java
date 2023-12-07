package interface_adapter.edit_spotify_handle;

import use_case.edit_spotify_handle.EditSpotifyHandleInputBoundary;
import use_case.edit_spotify_handle.EditSpotifyHandleInputData;

public class MockEditSpotifyHandleInteractor implements EditSpotifyHandleInputBoundary {
    private String currentState;

    public MockEditSpotifyHandleInteractor() {
        this.currentState = "";
    }

    public String getState() {
        return this.currentState;
    }

    @Override
    public void execute(String string, EditSpotifyHandleInputData inputData) {
        this.currentState = "Success";
    }
}