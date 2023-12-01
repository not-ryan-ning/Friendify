package use_case.edit_spotify_handle;

import entity.User;

public class EditSpotifyHandleInteractor implements EditSpotifyHandleInputBoundary {
    final EditSpotifyHandleUserDataAccessInterface editSpotifyHandleUserDAO;
    final EditSpotifyHandleOutputBoundary editSpotifyHandlePresenter;

    public EditSpotifyHandleInteractor(EditSpotifyHandleUserDataAccessInterface editSpotifyHandleUserDataAccessInterface,
                                       EditSpotifyHandleOutputBoundary editSpotifyHandleOutputBoundary) {
        this.editSpotifyHandleUserDAO = editSpotifyHandleUserDataAccessInterface;
        this.editSpotifyHandlePresenter = editSpotifyHandleOutputBoundary;
    }

    @Override
    public void execute(String username, EditSpotifyHandleInputData editSpotifyHandleInputData) {
        //get the new spotify handle from the input data
        String newSpotifyHandle = editSpotifyHandleInputData.getNewSpotifyHandle();
        //set the current user's profile's bio attribute to the new bio
        User currentUser = editSpotifyHandleUserDAO.get(username);
        currentUser.getProfile().setSpotifyHandle(newSpotifyHandle);
        //save the new bio in the csv
        editSpotifyHandleUserDAO.editFile(currentUser.getUsername(), "spotifyHandle", newSpotifyHandle);

        //output data
        EditSpotifyHandleOutputData editSpotifyHandleOutputData =
                new EditSpotifyHandleOutputData(currentUser.getProfile().getSpotifyHandle());
        //invoking the presenter
        editSpotifyHandlePresenter.prepareSuccessView(editSpotifyHandleOutputData);
    }
}
