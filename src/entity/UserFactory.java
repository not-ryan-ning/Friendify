package entity;

import java.util.ArrayList;

/**
 *  The UserFactory interface defines a template for classes that implement
 *  user creation.
 */
public interface UserFactory {
    /**
     * Creates a User instance with the specified initial attributes.
     *
     * @param username  A String representing the user's username.
     * @param password  A String representing the user's password.
     * @param profile   An instance of the Profile interface containing information about the user.
     * @param playlist  An instance of the Playlist interface representing the user's personal playlist.
     * @param friends   An ArrayList containing the usernames of the user's friends.
     * @param requests  An ArrayList containing the usernames of pending friend requests.
     * @return A User object with the specified initial attributes.
     */
    User create(String username, String password, Profile profile, Playlist playlist, ArrayList<String> friends, ArrayList<String> requests);
}
