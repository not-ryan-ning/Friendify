package interface_adapter.choose_playlist;

import entity.User;
import interface_adapter.logged_in.LoggedInState;
import use_case.choose_playlist.ChoosePlaylistInputBoundary;
import use_case.choose_playlist.ChoosePlaylistInputData;

/**
 * Initiates the operations related to choosing a playlist
 */
public class ChoosePlaylistController {
    final ChoosePlaylistInputBoundary choosePlaylistInputInteractor;

    public ChoosePlaylistController(ChoosePlaylistInputBoundary choosePlaylistInputInteractor) {
        this.choosePlaylistInputInteractor = choosePlaylistInputInteractor;
    }

    /**
     * Executes the function of choosing a playlist with the specified parameters.
     * @param username The username associated with the playlist.
     * @param playlistId The ID of the chosen playlist.
     * @param playlistName The name of the chosen playlist.
     * @param access_token The access token required for authorization.
     */
    public void execute(String username, String playlistId, String playlistName, String access_token) {
        ChoosePlaylistInputData choosePlaylistInputData = new ChoosePlaylistInputData(playlistId, playlistName,
                access_token);

        choosePlaylistInputInteractor.execute(username, choosePlaylistInputData);
    }
}
