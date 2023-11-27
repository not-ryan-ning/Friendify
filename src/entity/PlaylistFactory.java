package entity;

import java.util.ArrayList;
import java.util.HashMap;

public interface PlaylistFactory {
    Playlist create(String playlistId, HashMap<String, Integer> titles, HashMap<String, Integer> artists,
                    HashMap<String, Integer> genres, double acousticness, double energy,
                    double instrumentalness, double valence, ArrayList<String> topThreeArtists);
}