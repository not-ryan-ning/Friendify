package entity;

import java.util.ArrayList;

/**
 * Implementation of the Profile interface representing a friend profile with the attributes
 * bio, topThreeArtists and spotify handle of a user.
 */
public class FriendProfile implements Profile {
    private final String bio;
    private final ArrayList<String> topThreeArtists;
    private final String spotifyHandle;

    public FriendProfile(String bio, ArrayList<String> topThreeArtists, String spotifyHandle) {
        this.bio = bio;
        this.topThreeArtists = topThreeArtists;
        this.spotifyHandle = spotifyHandle;
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


