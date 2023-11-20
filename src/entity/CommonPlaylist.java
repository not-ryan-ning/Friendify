package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonPlaylist implements Playlist{
    private final String playlistId;
    private final HashMap<String, Integer> titles;
    private final HashMap<String, Integer> artists;
    private final HashMap<String, Integer> genres;
    private final double acousticness;
    private final double energy;
    private final double instrumentalness;
    private final double valence;
    private final ArrayList<String> topThreeArtists;

    public CommonPlaylist(String playlistId, HashMap<String, Integer> titles, HashMap<String, Integer> artists,
                          HashMap<String, Integer> genres, double acousticness, double energy,
                          double instrumentalness, double valence, ArrayList<String> topThreeArtists) {
        this.playlistId = playlistId;
        this.titles = titles;
        this.artists = artists;
        this.genres = genres;
        this.acousticness = acousticness;
        this.energy = energy;
        this.instrumentalness = instrumentalness;
        this.valence = valence;
        this.topThreeArtists = topThreeArtists;
    }
    @Override
    public String getPlaylistId() {
        return playlistId;
    }
    @Override
    public HashMap<String, Integer> getTitles() {
        return titles;
    }
    @Override
    public HashMap<String, Integer> getArtists() {
        return artists;
    }
    @Override
    public HashMap<String, Integer> getGenres() {
        return genres;
    }
    @Override
    public double getAcousticness() {
        return acousticness;
    }
    @Override
    public double getEnergy() {
        return energy;
    }
    @Override
    public double getInstrumentalness() {
        return instrumentalness;
    }
    @Override
    public double getValence() {
        return valence;
    }
    @Override
    public ArrayList<String> getTopThreeArtists() {
        return topThreeArtists;
    }
}
