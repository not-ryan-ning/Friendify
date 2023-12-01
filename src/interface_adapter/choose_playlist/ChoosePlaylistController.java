package interface_adapter.choose_playlist;

import entity.User;
import interface_adapter.logged_in.LoggedInState;
import use_case.choose_playlist.ChoosePlaylistInputBoundary;
import use_case.choose_playlist.ChoosePlaylistInputData;

public class ChoosePlaylistController {
    final ChoosePlaylistInputBoundary choosePlaylistInputInteractor;

    public ChoosePlaylistController(ChoosePlaylistInputBoundary choosePlaylistInputInteractor) {
        this.choosePlaylistInputInteractor = choosePlaylistInputInteractor;
    }

    public void execute(String username, String playlistId, String playlistName, String access_token) {
        ChoosePlaylistInputData choosePlaylistInputData = new ChoosePlaylistInputData(playlistId, playlistName,
                access_token);

        choosePlaylistInputInteractor.execute(username, choosePlaylistInputData);
    }
}
