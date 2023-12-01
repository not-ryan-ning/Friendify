package use_case.login;

import entity.User;

import java.util.ArrayList;

public class LoginOutputData {
    private final String username;
    private final String bio;
    private final ArrayList<String> topThreeArtists;
    private final String spotifyHandle;
    private boolean useCaseFailed;
    public LoginOutputData(String username, String bio, ArrayList<String> topThreeArtists, String spotifyHandle, boolean useCaseFailed) {
        this.username = username;
        this.bio = bio;
        this.topThreeArtists = topThreeArtists;
        this.spotifyHandle = spotifyHandle;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }
    public String getBio() { return bio; }
    public ArrayList<String> getTopThreeArtists() { return topThreeArtists; }

    public String getSpotifyHandle() { return spotifyHandle; }
}
