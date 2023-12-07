package data_access.choose_playlist;

import entity.*;
import use_case.choose_playlist.ChoosePlaylistUserDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class MockChoosePlaylistUserDataAccessObject implements ChoosePlaylistUserDataAccessInterface {
    @Override
    public User get(String username) {
        ProfileFactory profileFactory = new CommonProfileFactory();
        PlaylistFactory playlistFactory = new CommonPlaylistFactory();
        UserFactory userFactory = new CommonUserFactory();

        Profile emptyProfile = profileFactory.create("", new ArrayList<>(), "");
        Playlist emptyPlaylist = playlistFactory.create("1", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                0.0, 0.0 ,0.0, 0.0, new ArrayList<>());

        User user = userFactory.create("", "", emptyProfile, emptyPlaylist,
                new ArrayList<>(), new ArrayList<>());

        return user;
    }

    @Override
    public void editPlaylist(String username, Playlist playlist) {

    }
}
