package interface_adapter.choose_playlist;

import interface_adapter.accept_request.AcceptRequestState;

import java.util.ArrayList;

/**
 * Represents the state of choosing a playlist, including the playlist name, playlist ID, and access token.
 */
public class ChoosePlaylistState {
    private String playlistName = "";
    private String playlistId = "";
    private ArrayList<String> topThreeArtists;
    private String accessToken = "";


    public ChoosePlaylistState(ChoosePlaylistState copy) {
        playlistName = copy.playlistName;
        playlistId = copy.playlistId;
        topThreeArtists = copy.topThreeArtists;
        accessToken = copy.accessToken;
    }

    public ChoosePlaylistState() {}

    public String getPlaylistName() { return playlistName; }
    public String getPlaylistId() { return playlistId; }
    public ArrayList<String> getTopThreeArtists() { return topThreeArtists; }
    public String getAccessToken() { return accessToken; }

    public void setPlaylistName(String playlistName) { this.playlistName = playlistName; }
    public void setPlaylistId(String playlistId) { this.playlistId = playlistId; }
    public void setTopThreeArtists(ArrayList<String> topThreeArtists) { this.topThreeArtists = topThreeArtists; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
}
