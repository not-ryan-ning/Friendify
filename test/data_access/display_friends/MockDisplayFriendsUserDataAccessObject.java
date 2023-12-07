package data_access.display_friends;

import entity.*;
import use_case.display_friends.DisplayFriendsUserDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class MockDisplayFriendsUserDataAccessObject implements DisplayFriendsUserDataAccessInterface {
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
}
