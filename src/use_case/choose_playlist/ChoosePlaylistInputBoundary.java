package use_case.choose_playlist;

import entity.User;

public interface ChoosePlaylistInputBoundary {
    void execute(String username, ChoosePlaylistInputData choosePlaylistInputData);
}
