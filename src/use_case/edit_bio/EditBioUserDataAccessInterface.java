package use_case.edit_bio;

import entity.User;

public interface EditBioUserDataAccessInterface {
    User get(String username);
    void editFile(String Username, String column, String newValue);
}