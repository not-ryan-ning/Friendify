package entity;

import java.util.ArrayList;

public class CommonPlaylistFactory implements PlaylistFactory{
    @Override
    public CommonPlaylist create(String playlistID, ArrayList<String> topThreeArtists) {
        return new CommonPlaylist(playlistID, topThreeArtists);
    }
}
