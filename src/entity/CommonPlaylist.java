package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonPlaylist implements Playlist{
    private String playlistId;
    private ArrayList<String> titles;
    private HashMap<String, Integer> artists;
    private HashMap<String, Integer> genres;
    private double acousticness;
    private double energy;
    private double instrumentalness;
    private double valence;
    private ArrayList<String> topThreeArtists;

    public CommonPlaylist(String playlistId, ArrayList<String> titles, HashMap<String, Integer> artists,
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
    public ArrayList<String> getTitles() {
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

    @Override
    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    @Override
    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }

    @Override
    public void setArtists(HashMap<String, Integer> artists) {
        this.artists = artists;
    }

    @Override
    public void setGenres(HashMap<String, Integer> genres) {
        this.genres = genres;
    }

    @Override
    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }

    @Override
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    @Override
    public void setInstrumentalness(double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    @Override
    public void setValence(double valence) {
        this.valence = valence;
    }

    @Override
    public void setTopThreeArtists(ArrayList<String> topThreeArtists) {
        this.topThreeArtists = topThreeArtists;
    }
}
