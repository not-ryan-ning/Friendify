package entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Playlist interface represents a user's Spotify playlist and defines methods
 *  for accessing various attributes and characteristics of the playlist.
 */
public interface Playlist {
    public String getPlaylistId();
    public ArrayList<String> getTitles();
    public HashMap<String, Integer> getArtists();
    public HashMap<String, Integer> getGenres();
    public double getAcousticness();
    public double getEnergy();
    public double getInstrumentalness();
    public double getValence();
    public ArrayList<String> getTopThreeArtists();
    public void setPlaylistId(String playlistId);
    public void setTitles(ArrayList<String> titles);
    public void setArtists(HashMap<String, Integer> artists);
    public void setGenres(HashMap<String, Integer> genres);
    public void setAcousticness(double acousticness);
    public void setEnergy(double energy);
    public void setInstrumentalness(double instrumentalness);
    public void setValence(double valence);
    public void setTopThreeArtists(ArrayList<String> topThreeArtists);
}
