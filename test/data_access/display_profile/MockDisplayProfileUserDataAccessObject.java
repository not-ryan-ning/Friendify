package data_access.display_profile;

import entity.*;
import use_case.display_profile.DisplayProfileUserDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class MockDisplayProfileUserDataAccessObject implements DisplayProfileUserDataAccessInterface {
    @Override
    public User get(String username) {
        ProfileFactory profileFactory = new CommonProfileFactory();
        PlaylistFactory playlistFactory = new CommonPlaylistFactory();
        UserFactory userFactory = new CommonUserFactory();

        Profile emptyProfile = profileFactory.create("", new ArrayList<>(), "");
        Playlist emptyPlaylist = playlistFactory.create("", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                0.0, 0.0 ,0.0, 0.0, new ArrayList<>());

        ArrayList<String> friends = new ArrayList<>();
        friends.add("Josh Hutcherson");

        User user = userFactory.create("", "", emptyProfile, emptyPlaylist,
                friends, new ArrayList<>());

        return user;
    }
}
