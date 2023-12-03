package interface_adapter.display_friend_profile;

import java.util.ArrayList;

public class DisplayFriendProfileState {
    private String username;
    private String bio;
    private ArrayList<String> topThreeArtists;
    private String spotifyHandle;

    /**
     * Constructs a new DisplayFriendProfileState instance by copying the state from another instance.
     *
     * @param copy The DisplayFriendProfileState to copy from.
     */
    public DisplayFriendProfileState(DisplayFriendProfileState copy) {
        this.username = copy.username;
        this.bio = copy.bio;
        this.topThreeArtists = copy.topThreeArtists;
        this.spotifyHandle = copy.spotifyHandle;
    }

    /**
     * Constructs a new DisplayFriendProfileState instance
     */
    public DisplayFriendProfileState() {}

    /**
     * Gets the username associated with this state.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public ArrayList<String> getTopThreeArtists() { return topThreeArtists; }
    public void setTopThreeArtists(ArrayList<String> topThreeArtists) { this.topThreeArtists = topThreeArtists; }
    public String getSpotifyHandle() { return spotifyHandle; }
    public void setSpotifyHandle(String spotifyHandle) { this.spotifyHandle = spotifyHandle; }
}
