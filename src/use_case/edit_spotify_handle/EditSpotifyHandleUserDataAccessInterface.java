package use_case.edit_spotify_handle;

import entity.User;

public interface EditSpotifyHandleUserDataAccessInterface {
    void saveSpotifyHandle(User user, String spotifyHandle);
}

