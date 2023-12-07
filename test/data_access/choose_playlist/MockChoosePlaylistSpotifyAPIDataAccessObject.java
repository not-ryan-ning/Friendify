package data_access.choose_playlist;

import use_case.choose_playlist.ChoosePlaylistSpotifyAPIDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MockChoosePlaylistSpotifyAPIDataAccessObject implements ChoosePlaylistSpotifyAPIDataAccessInterface {
    @Override
    public ArrayList<Object> getPlaylistInfo(String username, String playlistId, String access_token) {

        ArrayList<Object> customPlaylist = new ArrayList<>();
        customPlaylist.add(new ArrayList<>(List.of("title1")));

        HashMap<String, Integer> artists = new HashMap<>();
        artists.put("artist1", 1);
        customPlaylist.add(artists);

        HashMap<String, Integer> genres = new HashMap<>();
        genres.put("genre1", 1);
        customPlaylist.add(genres);

        customPlaylist.add(1.0);
        customPlaylist.add(2.0);
        customPlaylist.add(3.0);
        customPlaylist.add(4.0);

        customPlaylist.add(new ArrayList<>(List.of("artist1")));

        return customPlaylist;
    }
}
