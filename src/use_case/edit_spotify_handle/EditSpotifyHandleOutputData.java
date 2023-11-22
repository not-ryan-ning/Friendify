package use_case.edit_spotify_handle;

public class EditSpotifyHandleOutputData {
    private String newSpotifyHandle;

    public EditSpotifyHandleOutputData(String newSpotifyHandle) {
        this.newSpotifyHandle = newSpotifyHandle;
    }
    public String getNewSpotifyHandle() {
        return newSpotifyHandle;
    }
}