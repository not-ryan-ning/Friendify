package use_case.edit_spotify_handle;

import entity.User;

public interface EditSpotifyHandleUserDataAccessInterface {
    void editFile(String Username, String column, String newValue);
}