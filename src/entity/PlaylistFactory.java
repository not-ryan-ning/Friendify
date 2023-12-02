package entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The PlaylistFactory interface defines a template for classes that implement
 * playlist creation.
 */
public interface PlaylistFactory {
    /**
     * Creates a Playlist instance with the specified attributes.
     *
     * @param playlistId A unique identifier for the playlist.
     * @param titles An ArrayList containing the titles of the songs in the playlist.
     * @param artists  A HashMap containing artist names as keys and their frequencies in the playlist.
     * @param genres A HashMap containing genre names as keys and their frequencies in the playlist.
     * @param acousticness A double representing the acousticness of the playlist.
     * @param energy A double representing the energy of the playlist.
     * @param instrumentalness A double representing the instrumentalness of the playlist.
     * @param valence A double representing the valence of the playlist.
     * @param topThreeArtists An ArrayList containing the names of the top three artists in the playlist.
     * @return A Playlist object with the specified attributes.
     */
    Playlist create(String playlistId, ArrayList<String> titles, HashMap<String, Integer> artists,
                    HashMap<String, Integer> genres, double acousticness, double energy,
                    double instrumentalness, double valence, ArrayList<String> topThreeArtists);
}

