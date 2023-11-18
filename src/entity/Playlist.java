package entity;

import java.util.ArrayList;

public interface Playlist {
    public String getPlaylistId();
    public ArrayList<String> getArtists();
    public ArrayList<String> getTitles();
    public double getAcousticness();
    public double getEnergy();
    public double getInstrumentalness();
    public double getValence();
    public ArrayList<String> getTopThreeArtists();
}
