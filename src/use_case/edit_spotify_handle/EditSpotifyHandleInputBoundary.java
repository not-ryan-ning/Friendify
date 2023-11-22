package use_case.edit_spotify_handle;

import entity.User;

public interface EditSpotifyHandleInputBoundary {
    void execute(User currentUser, EditSpotifyHandleInputData editSpotifyHandleInputData);
}