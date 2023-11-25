package use_case.choose_playlist;

import entity.User;

public interface ChoosePlaylistInputBoundary {
    void execute(User user, ChoosePlaylistInputData choosePlaylistInputData);
}
