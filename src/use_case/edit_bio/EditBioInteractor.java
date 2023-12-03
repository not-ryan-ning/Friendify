package use_case.edit_bio;

import entity.User;

public class EditBioInteractor implements EditBioInputBoundary {
    final EditBioUserDataAccessInterface editBioUserDAO;
    final EditBioOutputBoundary editBioPresenter;

    public EditBioInteractor(EditBioUserDataAccessInterface editBioUserDataAccessInterface,
                             EditBioOutputBoundary editBioOutputBoundary) {
        this.editBioUserDAO = editBioUserDataAccessInterface;
        this.editBioPresenter = editBioOutputBoundary;
    }

    /**
     * Allows a user to change and save their bio.
     * @param username The username of the user that wants to change their bio.
     * @param editBioInputData Input data that contains the new bio to change to.
     */
    @Override
    public void execute(String username, EditBioInputData editBioInputData) {
        //get the new bio from the input data
        String newBio = editBioInputData.getNewBio();
        //set the current user's profile's bio attribute to the new bio
        User currentUser = editBioUserDAO.get(username);
        currentUser.getProfile().setBio(newBio);
        //save the new bio in the csv
        editBioUserDAO.editFile(currentUser.getUsername(), "bio", newBio);

        //output data
        EditBioOutputData editBioOutputData = new EditBioOutputData(currentUser.getProfile().getBio());
        //invoking the presenter
        editBioPresenter.prepareSuccessView(editBioOutputData);
    }
}