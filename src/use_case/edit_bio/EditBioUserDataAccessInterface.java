package use_case.edit_bio;

import entity.User;
public interface EditBioUserDataAccessInterface {
    void saveBio(User user, String newBio);
}
