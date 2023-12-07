package data_access.choose_playlist;

import entity.CommonPlaylistFactory;
import entity.Playlist;
import entity.PlaylistFactory;
import use_case.choose_playlist.ChoosePlaylistPlaylistDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class MockChoosePlaylistPlaylistDataAccessObject implements ChoosePlaylistPlaylistDataAccessInterface {

    @Override
    public void storePlaylist(Playlist playlist) {

    }

    @Override
    public boolean isIn(String playlistId) {
        return playlistId.equals("check");
    }

    @Override
    public Playlist getPlaylist(String playlistId) {
        if (playlistId.equals("check")) {
            PlaylistFactory playlistFactory = new CommonPlaylistFactory();
            return playlistFactory.create("", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                    0.0, 0.0, 0.0, 1.0, new ArrayList<>());
        }

        return null;
    }
}
