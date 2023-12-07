package data_access.send_request;

import entity.*;
import use_case.send_request.SendRequestUserDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class MockSendRequestUserDataAccessObject implements SendRequestUserDataAccessInterface {
    @Override
    public boolean isRequested(User sender, User receiver) {
        return !sender.getUsername().isEmpty() || receiver.getUsername().isEmpty();
    }

    @Override
    public ArrayList<String> sendFriendRequest(User sender, User receiver) {
        receiver.getRequests().add(sender.getUsername());
        return receiver.getRequests();
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

        User user = userFactory.create("Receiver", "", emptyProfile, emptyPlaylist,
                new ArrayList<>(), new ArrayList<>());

        return user;
    }

    @Override
    public void editFile(String Username, String column, String newValue) {

    }
}
