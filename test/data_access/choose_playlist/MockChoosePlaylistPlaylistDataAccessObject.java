package data_access.choose_playlist;

import entity.CommonPlaylistFactory;
import entity.Playlist;
import entity.PlaylistFactory;
import use_case.choose_playlist.ChoosePlaylistPlaylistDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class MockChoosePlaylistPlaylistDataAccessObject implements ChoosePlaylistPlaylistDataAccessInterface {

    private PlaylistFactory playlistFactory;


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
            this.playlistFactory = new CommonPlaylistFactory();
            Playlist playlist = playlistFactory.create("", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                    0.0, 0.0, 0.0, 1.0, new ArrayList<>());
            return playlist;
        }

        return null;
    }
}
