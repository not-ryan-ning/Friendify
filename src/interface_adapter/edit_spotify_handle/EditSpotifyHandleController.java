package interface_adapter.edit_spotify_handle;

import entity.User;
import use_case.edit_spotify_handle.EditSpotifyHandleInputBoundary;
import use_case.edit_spotify_handle.EditSpotifyHandleInputData;

public class EditSpotifyHandleController {
    final EditSpotifyHandleInputBoundary editSpotifyHandleInteractor;

    public EditSpotifyHandleController(EditSpotifyHandleInputBoundary editSpotifyHandleInteractor) {
        this.editSpotifyHandleInteractor = editSpotifyHandleInteractor;
    }

    public void execute(User currentUsername, String newBio) {
        EditSpotifyHandleInputData editBioInputData = new EditSpotifyHandleInputData(newBio);
        editSpotifyHandleInteractor.execute(currentUsername, editBioInputData);
    }
}