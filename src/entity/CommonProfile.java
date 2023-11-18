package entity;

import java.util.ArrayList;

public class CommonProfile implements Profile {
    final String bio;
    final ArrayList<String> topThreeArtists;
    final String spotifyHandle;

    CommonProfile(String bio,
                  ArrayList<String> topThreeArtists,
                  String spotifyHandle) {
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
