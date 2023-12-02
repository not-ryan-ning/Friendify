package entity;

import java.util.ArrayList;

public class CommonProfile implements Profile{
    private String bio;
    private ArrayList<String> topThreeArtists;
    private String spotifyHandle;

    public CommonProfile(String bio, ArrayList<String> topThreeArtists, String spotifyHandle) {
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
    @Override
    public void setBio(String bio) { this.bio = bio; }
    @Override
    public void setTopThreeArtists(ArrayList<String> topThreeArtists) { this.topThreeArtists = topThreeArtists; }
    @Override
    public void setSpotifyHandle(String spotifyHandle) { this.spotifyHandle = spotifyHandle; }

}
