package interface_adapter.edit_profile;

import use_case.edit_profile.EditProfileInputBoundary;

/**
 * Initiates operations related to editing user profile
 */
public class EditProfileController {
    final EditProfileInputBoundary editProfileInteractor;

    public EditProfileController(EditProfileInputBoundary editProfileInteractor) {
        this.editProfileInteractor = editProfileInteractor;
    }

    /**
     * Executes operation of editing user profile
     */
    public void execute(){
        editProfileInteractor.execute();
    }
}
