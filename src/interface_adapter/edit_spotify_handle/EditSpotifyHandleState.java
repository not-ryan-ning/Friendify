package interface_adapter.edit_spotify_handle;

/**
 * Represents the state of editing a user's spotify handle
 */
public class EditSpotifyHandleState {
    private String spotifyHandle;

    public EditSpotifyHandleState(EditSpotifyHandleState copy) {
        this.spotifyHandle = copy.spotifyHandle;
    }
    public EditSpotifyHandleState(){}
    public String getSpotifyHandle() {
        return spotifyHandle;
    }
    public void setSpotifyHandle(String spotifyHandle) {
        this.spotifyHandle = spotifyHandle;
    }
}