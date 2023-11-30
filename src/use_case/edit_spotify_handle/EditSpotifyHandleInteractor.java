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
    public void execute(String currentUsername, EditSpotifyHandleInputData editSpotifyHandleInputData) {
        String newSpotifyHandle = editSpotifyHandleInputData.getNewSpotifyHandle();
        User currentUser = editSpotifyHandleUserDAO.get(currentUsername);
        currentUser.getProfile().setSpotifyHandle(newSpotifyHandle);
        //save the new spotify handle in the csv
        editSpotifyHandleUserDAO.editFile(currentUser.getUsername(), "4", newSpotifyHandle);

        //output data
        EditSpotifyHandleOutputData editSpotifyHandleOutputData =
                new EditSpotifyHandleOutputData(currentUser.getProfile().getSpotifyHandle());
        //invoking the presenter
        editSpotifyHandlePresenter.prepareSuccessView(editSpotifyHandleOutputData);
    }
}
