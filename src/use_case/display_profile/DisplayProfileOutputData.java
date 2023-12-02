package use_case.display_profile;

import entity.Profile;

import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class DisplayProfileOutputData {
    private String bio;
    private ArrayList<String> topThreeArtists;
    private String spotifyHandle;

    public DisplayProfileOutputData(String bio, ArrayList<String> topThreeArtists, String spotifyHandle) {
        this.bio = bio;
        this.topThreeArtists = topThreeArtists;
        this.spotifyHandle = spotifyHandle;
    }

    public String getBio() {
        return bio;
    }
    public ArrayList<String> getTopThreeArtists() {
        return topThreeArtists;
    }
    public String getSpotifyHandle() {
        return spotifyHandle;
    }

}
