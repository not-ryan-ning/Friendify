package interface_adapter.display_common_profile;

import java.util.ArrayList;

public class DisplayCommonProfileState {
    private String username;
    private String bio;
    private ArrayList<String> topThreeArtists;

    public DisplayCommonProfileState(DisplayCommonProfileState copy) {
        this.username = copy.username;
        this.bio = copy.bio;
        this.topThreeArtists = copy.topThreeArtists;
    }

    public DisplayCommonProfileState() {}

    public String getUsername() {
        return username;
    }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public ArrayList<String> getTopThreeArtists() { return topThreeArtists; }
    public void setTopThreeArtists(ArrayList<String> topThreeArtists) { this.topThreeArtists = topThreeArtists; }
}