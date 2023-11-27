package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonPlaylistFactory implements PlaylistFactory {
    @Override
    public CommonPlaylist create(String playlistId, ArrayList<String> titles, HashMap<String, Integer> artists,
                                 HashMap<String, Integer> genres, double acousticness, double energy,
                                 double instrumentalness, double valence, ArrayList<String> topThreeArtists) {
        return new CommonPlaylist(playlistId, titles, artists, genres, acousticness, energy, instrumentalness,
                valence, topThreeArtists);
    }
}
