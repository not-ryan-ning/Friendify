package entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implementation of the Playlist interface representing a common playlist with the attributes
 * playlist ID, titles, artists, genres, acousticness, energy, instrumentalness, valence, and top three artists.
 */
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


    /**
     * Constructs a CommonPlaylist object with the specified attributes.
     *
     * @param playlistId The unique identifier for the playlist.
     * @param titles The list of song titles in the playlist.
     * @param artists A mapping of artist names to their frequencies in the playlist.
     * @param genres A mapping of genre names to their frequencies in the playlist.
     * @param acousticness The acousticness value of the playlist.
     * @param energy The energy value of the playlist.
     * @param instrumentalness The instrumentalness value of the playlist.
     * @param valence The valence value of the playlist
     * @param topThreeArtists The list of the top three artists in the playlist.
     */
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
