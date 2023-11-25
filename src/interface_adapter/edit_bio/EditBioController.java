package interface_adapter.edit_bio;

import entity.User;
import use_case.edit_bio.EditBioInputBoundary;
import use_case.edit_bio.EditBioInputData;
public class EditBioController {
    final EditBioInputBoundary editBioInteractor;

    public EditBioController(EditBioInputBoundary editBioInteractor) {
        this.editBioInteractor = editBioInteractor;
    }

    public void execute(User currentUser, String newBio) {
        EditBioInputData editBioInputData = new EditBioInputData(newBio);
        editBioInteractor.execute(currentUser, editBioInputData);
    }
}