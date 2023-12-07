package data_access.login;

import entity.*;
import use_case.login.LoginUserDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class MockLoginUserDataAccessObject implements LoginUserDataAccessInterface {
    @Override
    public boolean existsByName(String identifier) {
        return !identifier.equals("failureUser");
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User get(String username) {
        ProfileFactory profileFactory = new CommonProfileFactory();
        PlaylistFactory playlistFactory = new CommonPlaylistFactory();
        UserFactory userFactory = new CommonUserFactory();

        Profile emptyProfile = profileFactory.create("", new ArrayList<>(), "");
        Playlist emptyPlaylist = playlistFactory.create("1", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                0.0, 0.0 ,0.0, 0.0, new ArrayList<>());
        if (username.isEmpty()) {
            User user = userFactory.create("", "", emptyProfile, emptyPlaylist,
                    new ArrayList<>(), new ArrayList<>());

            return user;
        }
        User user = userFactory.create("", "", null, null,
                null, null);

        return user;
    }
}
