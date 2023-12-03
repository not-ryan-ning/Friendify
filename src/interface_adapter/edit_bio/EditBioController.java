package interface_adapter.edit_bio;

import entity.User;
import use_case.edit_bio.EditBioInputBoundary;
import use_case.edit_bio.EditBioInputData;

/**
 * Initializes operations related to editing a user's bio.
 */
public class EditBioController {
    final EditBioInputBoundary editBioInteractor;

    public EditBioController(EditBioInputBoundary editBioInteractor) {
        this.editBioInteractor = editBioInteractor;
    }
    /**
     * Executes the operation of editing user bio for the specified username
     *
     * @param username The username of user that wants to edit their bio.
     * @param newBio   The new bio to set for the user.
     * */
    public void execute(String username, String newBio) {
        EditBioInputData editBioInputData = new EditBioInputData(newBio);
        editBioInteractor.execute(username, editBioInputData);
    }
}