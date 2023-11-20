package entity;

import java.util.ArrayList;

public interface Profile {
    public String getBio();
    public ArrayList<String> getTopThreeArtists();
    public String getSpotifyHandle();
    public void setBio();
    public void setSpotifyHandle();
    public void setTopThreeArtists();
}
