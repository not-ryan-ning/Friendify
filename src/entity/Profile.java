package entity;

import java.util.ArrayList;

/**
 * The Profile interface represents a user profile and defines methods
 * for accessing and modifying various attributes of the profile.
 */
public interface Profile {
    String getBio();
    ArrayList<String> getTopThreeArtists();
    String getSpotifyHandle();
    void setBio(String bio);
    void setTopThreeArtists(ArrayList<String> topThreeArtists);
    void setSpotifyHandle(String spotifyHandle);
}