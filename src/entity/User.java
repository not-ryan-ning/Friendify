package entity;
import java.util.ArrayList;

/**
 * The User interface represents a user in the system and defines methods
 * for accessing various attributes and functionalities related to the user.
 */
public interface User {
    String getUsername();
    String getPassword();
    Profile getProfile();
    Playlist getPlaylist();
    ArrayList<String> getFriends();
    ArrayList<String> getRequests();
    void setPlaylist(Playlist playlist);
}