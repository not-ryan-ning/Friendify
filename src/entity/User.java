package entity;
import java.util.ArrayList;

public interface User {
    String getUsername();
    String getPassword();
    Profile getProfile();
    Playlist getPlaylist();
    ArrayList<String> getFriends();
    ArrayList<String> getRequests();
    void setProfile(Profile profile);
    void setPlaylist(Playlist playlist);
    void setFriends(ArrayList<String> friends);
    void setRequests(ArrayList<String> requests);
}