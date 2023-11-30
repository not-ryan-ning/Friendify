package interface_adapter.edit_bio;

import entity.User;
import use_case.edit_bio.EditBioInputBoundary;
import use_case.edit_bio.EditBioInputData;
public class EditBioController {
    final EditBioInputBoundary editBioInteractor;

    public EditBioController(EditBioInputBoundary editBioInteractor) {
        this.editBioInteractor = editBioInteractor;
    }

    public void execute(String username, String newBio) {
        EditBioInputData editBioInputData = new EditBioInputData(newBio);
        editBioInteractor.execute(username, editBioInputData);
    }
}