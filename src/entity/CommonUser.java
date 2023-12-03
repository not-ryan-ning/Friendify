package entity;

import java.util.ArrayList;

/**
 * Implementation of the User interface representing a common user with the attributes
 * username, password, profile, playlist, friends, and requests.
 */
public class CommonUser implements User {
    private final String username;
    private final String password;
    private Profile profile;
    private Playlist playlist;
    private ArrayList<String> friends;
    private ArrayList<String> requests;

    public CommonUser(String username, String password, Profile profile, Playlist playlist, ArrayList<String> friends, ArrayList<String> requests) {
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.playlist = playlist;
        this.friends = friends;
        this.requests = requests;
    }

    @Override
    public String getUsername() { return username; }
    @Override
    public String getPassword() { return password; }
    @Override
    public Profile getProfile() { return profile; }
    @Override
    public Playlist getPlaylist() { return playlist; }
    @Override
    public ArrayList<String> getFriends() { return friends; }
    @Override
    public ArrayList<String> getRequests() { return requests; }
    @Override
    public void setProfile(Profile profile) { this.profile = profile; }
    @Override
    public void setPlaylist(Playlist playlist) { this.playlist = playlist; }
    @Override
    public void setFriends(ArrayList<String> friends) { this.friends = friends; }
    @Override
    public void setRequests(ArrayList<String> requests) { this.requests = requests; }
}
