package entity;

import java.util.ArrayList;

public class CommonUser implements User {
    private final String username;
    private final String password;
    private final Profile profile;
    private final Playlist playlist;
    private final ArrayList<String> friends;
    private final ArrayList<String> requests;

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
}
