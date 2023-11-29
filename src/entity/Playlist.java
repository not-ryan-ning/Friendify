package entity;

import java.util.ArrayList;
import java.util.HashMap;

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
