package use_case.edit_spotify_handle;

public class EditSpotifyHandleInputData {
    private String newSpotifyHandle;

    public EditSpotifyHandleInputData(String newSpotifyHandle) {
        this.newSpotifyHandle = newSpotifyHandle;
    }
    String getNewSpotifyHandle() {
        return newSpotifyHandle;
    }
}
