package entity;

import java.util.ArrayList;

public class FriendProfile implements Profile {
    private final String bio;
    private final ArrayList<String> topThreeArtists;
    private final String spotifyHandle;

    public FriendProfile(String bio, ArrayList<String> topThreeArtists, String spotifyHandle) {
        this.bio = bio;
        this.topThreeArtists = topThreeArtists;
        this.spotifyHandle = spotifyHandle;
    }

    public FriendProfile() {
    }

    @Override
    public String getBio() {
        return bio;
    }
    @Override
    public ArrayList<String> getTopThreeArtists() {
        return topThreeArtists;
    }
    @Override
    public String getSpotifyHandle() {
        return spotifyHandle;
    }
}


