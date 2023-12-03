package interface_adapter.display_common_profile;

import java.util.ArrayList;

public class DisplayCommonProfileState {
    private String username;
    private String bio;
    private ArrayList<String> topThreeArtists;

    /**
     * Constructs a new DisplayCommonProfileState instance by copying the state from another instance.
     *
     * @param copy The DisplayCommonProfileState to copy from.
     */
    public DisplayCommonProfileState(DisplayCommonProfileState copy) {
        this.username = copy.username;
        this.bio = copy.bio;
        this.topThreeArtists = copy.topThreeArtists;
    }

    /**
     * Constructs a new DisplayCommonProfileState instance
     */
    public DisplayCommonProfileState() {}

    /**
     * Gets the username associated with this state.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }
    public String getBio() { return bio; }
    public ArrayList<String> getTopThreeArtists() { return topThreeArtists; }
    public void setUsername(String username) { this.username = username; }
    public void setBio(String bio) { this.bio = bio; }
    public void setTopThreeArtists(ArrayList<String> topThreeArtists) { this.topThreeArtists = topThreeArtists; }
}