package interface_adapter;

import use_case.choose_playlist.ChoosePlaylistInputBoundary;
import use_case.choose_playlist.ChoosePlaylistInputData;

public class ChoosePlaylistController {
    final ChoosePlaylistInputBoundary choosePlaylistInputInteractor;

    public ChoosePlaylistController(ChoosePlaylistInputBoundary choosePlaylistInputInteractor) {
        this.choosePlaylistInputInteractor = choosePlaylistInputInteractor;
    }

    public void execute(String username, String playlistId, String access_token) {
        ChoosePlaylistInputData choosePlaylistInputData = new ChoosePlaylistInputData(username,
                playlistId, access_token);

        choosePlaylistInputInteractor.execute(choosePlaylistInputData);
    }
}
