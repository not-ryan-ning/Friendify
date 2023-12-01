package use_case.edit_bio;

import entity.User;

public interface EditBioInputBoundary {
    void execute(String username, EditBioInputData editBioInputData);
}