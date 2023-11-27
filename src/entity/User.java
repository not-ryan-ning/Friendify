package entity;
import java.util.ArrayList;

public interface User {
    String getUsername();
    String getPassword();
    Profile getProfile();
    Playlist getPlaylist();
    ArrayList<String> getFriends();
    ArrayList<String> getRequests();
}