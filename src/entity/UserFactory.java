package entity;

import java.util.ArrayList;

public interface UserFactory {
    User create(String username, String password, Profile profile, Playlist playlist, ArrayList<String> friends, ArrayList<String> requests);
}
