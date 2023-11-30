package use_case.edit_spotify_handle;

import entity.User;

public interface EditSpotifyHandleInputBoundary {
    void execute(String username, EditSpotifyHandleInputData editSpotifyHandleInputData);
}