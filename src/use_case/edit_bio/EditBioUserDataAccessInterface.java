package use_case.edit_bio;

import entity.User;
public interface EditBioUserDataAccessInterface {
    User get(String Username);
    void editFile(String Username, String column, String newValue);
}