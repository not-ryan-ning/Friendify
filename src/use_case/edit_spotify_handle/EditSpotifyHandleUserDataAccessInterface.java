package use_case.edit_spotify_handle;

import entity.User;

public interface EditSpotifyHandleUserDataAccessInterface {
    User get(String username);
    void editFile(String Username, String column, String newValue);
}