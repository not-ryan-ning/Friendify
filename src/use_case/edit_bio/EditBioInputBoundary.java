package use_case.edit_bio;

import entity.User;

public interface EditBioInputBoundary {
    void execute(User currentUser, EditBioInputData editBioInputData);
}
