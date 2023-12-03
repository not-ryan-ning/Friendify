package entity;

import java.util.ArrayList;

/**
 * Implementation of the UserFactory interface for creating instances of CommonUser.
 * This factory provides a method to create CommonUser objects with specified attributes.
 */
public class CommonUserFactory implements UserFactory {
    @Override
    public User create(String username, String password, Profile profile, Playlist playlist, ArrayList<String> friends, ArrayList<String> requests) {
        return new CommonUser(username, password, profile, playlist, friends, requests);
    }
}