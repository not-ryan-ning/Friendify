package entity;

import java.util.ArrayList;

public interface Profile {
    String getBio();
    ArrayList<String> getTopThreeArtists();
    String getSpotifyHandle();
    void setBio(String bio);
    void setTopThreeArtists(ArrayList<String> topThreeArtists);
    void setSpotifyHandle(String spotifyHandle);
}