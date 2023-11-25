package use_case.edit_bio;

import entity.User;

public class EditBioInteractor implements EditBioInputBoundary{
    final EditBioUserDataAccessInterface editBioUserDAO;
    final EditBioOutputBoundary editBioPresenter;

    public EditBioInteractor(EditBioUserDataAccessInterface editBioUserDataAccessInterface,
                             EditBioOutputBoundary editBioOutputBoundary) {
        this.editBioUserDAO = editBioUserDataAccessInterface;
        this.editBioPresenter = editBioOutputBoundary;
    }
    @Override
    public void execute(String currentUsername, EditBioInputData editBioInputData) {
        //get the new bio from the input data
        String newBio = editBioInputData.getNewBio();
        //set the current user's profile's bio attribute to the new bio
        User currentUser = editBioUserDAO.get(currentUsername);
        currentUser.getProfile().setBio(newBio);
        //save the new bio in the csv
        editBioUserDAO.editFile(currentUsername, "2", newBio);

        //output data
        EditBioOutputData editBioOutputData = new EditBioOutputData(currentUser.getProfile().getBio());
        //invoking the presenter
        editBioPresenter.prepareSuccessView(editBioOutputData);
    }
}