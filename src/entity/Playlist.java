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
}
