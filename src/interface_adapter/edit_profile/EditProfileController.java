package interface_adapter;

import use_case.edit_profile.EditProfileInputBoundary;

public class EditProfileController {
    final EditProfileInputBoundary editProfileInteractor;

    public EditProfileController(EditProfileInputBoundary editProfileInteractor) {
        this.editProfileInteractor = editProfileInteractor;
    }

    public void execute(){
        editProfileInteractor.execute();
    }
}
