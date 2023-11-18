package entity;

import java.util.ArrayList;

public interface PlaylistFactory {
    Playlist create(String playlistID,
                    ArrayList<String> topThreeArtists);
}
