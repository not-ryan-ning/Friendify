package interface_adapter;

import entity.User;
import use_case.choose_playlist.ChoosePlaylistInputBoundary;
import use_case.choose_playlist.ChoosePlaylistInputData;

public class ChoosePlaylistController {
    final ChoosePlaylistInputBoundary choosePlaylistInputInteractor;

    public ChoosePlaylistController(ChoosePlaylistInputBoundary choosePlaylistInputInteractor) {
        this.choosePlaylistInputInteractor = choosePlaylistInputInteractor;
    }

    public void execute(User user, String playlistId, String access_token) {
        ChoosePlaylistInputData choosePlaylistInputData = new ChoosePlaylistInputData(playlistId, access_token);

        choosePlaylistInputInteractor.execute(user, choosePlaylistInputData);
    }
}
