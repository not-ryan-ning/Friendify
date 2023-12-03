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

    /**
     * Updates the Spotify handle attribute of the user's profile
     * with the new Spotify handle provided in the input data and saves this
     * in the user data access object. Then, the presenter is notified with the updated information.
     * @param username The username of the user whose Spotify handle is to be edited.
     * @param editSpotifyHandleInputData The input data containing the new Spotify handle.
     */
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
