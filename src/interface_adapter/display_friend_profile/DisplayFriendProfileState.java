package interface_adapter.display_friend_profile;

import java.util.ArrayList;

public class DisplayFriendProfileState {
    private String username;
    private String bio;
    private ArrayList<String> topThreeArtists;
    private String spotifyHandle;

    public DisplayFriendProfileState(DisplayFriendProfileState copy) {
        this.username = copy.username;
        this.bio = copy.bio;
        this.topThreeArtists = copy.topThreeArtists;
        this.spotifyHandle = copy.spotifyHandle;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public DisplayFriendProfileState() {}

    public String getUsername() {
        return username;
    }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public ArrayList<String> getTopThreeArtists() { return topThreeArtists; }
    public void setTopThreeArtists(ArrayList<String> topThreeArtists) { this.topThreeArtists = topThreeArtists; }
    public String getSpotifyHandle() { return spotifyHandle; }
    public void setSpotifyHandle(String spotifyHandle) { this.spotifyHandle = spotifyHandle; }
}
