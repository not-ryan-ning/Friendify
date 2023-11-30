package entity;

import java.util.ArrayList;

public class CommonUserFactory implements UserFactory {
    @Override
    public User create(String username, String password, Profile profile, Playlist playlist, ArrayList<String> friends, ArrayList<String> requests) {
        return new CommonUser(username, password, profile, playlist, friends, requests);
    }
}