package interface_adapter.edit_spotify_handle;

import entity.User;
import use_case.edit_spotify_handle.EditSpotifyHandleInputBoundary;
import use_case.edit_spotify_handle.EditSpotifyHandleInputData;

/**
 * Initiates operations related to editing a user's spotify handle
 */
public class EditSpotifyHandleController {
    final EditSpotifyHandleInputBoundary editSpotifyHandleInteractor;

    public EditSpotifyHandleController(EditSpotifyHandleInputBoundary editSpotifyHandleInteractor) {
        this.editSpotifyHandleInteractor = editSpotifyHandleInteractor;
    }

    /**
     * Executes operation of editing a user's spotify handle
     */
    public void execute(String currentUsername, String newBio) {
        EditSpotifyHandleInputData editBioInputData = new EditSpotifyHandleInputData(newBio);
        editSpotifyHandleInteractor.execute(currentUsername, editBioInputData);
    }
}