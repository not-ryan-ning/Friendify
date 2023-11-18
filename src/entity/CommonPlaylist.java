package entity;

import java.util.ArrayList;

public class CommonPlaylist implements Playlist {
    private final String playlistID;
    private final ArrayList<String> topThreeArtists;

    CommonPlaylist(String playlistID, ArrayList<String> topThreeArtists) {
        this.playlistID = playlistID;
        this.topThreeArtists = topThreeArtists;
    }

    @Override
    public String getPlaylistID() {
        return playlistID;
    }

    @Override
    public ArrayList<String> getTopThreeArtists() {
        return topThreeArtists;
    }



}
