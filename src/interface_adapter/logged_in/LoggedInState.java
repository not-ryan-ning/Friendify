package interface_adapter.logged_in;

import entity.User;

import java.util.ArrayList;

/**
 * Represents the state of a user being logged in
 */
public class LoggedInState {
    private String username;
    private String bio;
    private ArrayList<String> topThreeArtists;
    private String spotifyHandle;

    public LoggedInState(LoggedInState copy) {
        username = copy.username;
        bio = copy.bio;
        topThreeArtists = copy.topThreeArtists;
        spotifyHandle = copy.spotifyHandle;
    }

    public LoggedInState() {}

    public String getUsername() {
        return username;
    }
    public String getBio() { return bio; }
    public ArrayList<String> getTopThreeArtists() { return topThreeArtists; }
    public String getSpotifyHandle() { return spotifyHandle; }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setBio(String bio) { this.bio = bio; }
    public void setTopThreeArtists(ArrayList<String> topThreeArtists) { this.topThreeArtists = topThreeArtists; }
    public void setSpotifyHandle(String spotifyHandle) { this.spotifyHandle = spotifyHandle; }
}
