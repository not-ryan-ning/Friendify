package interface_adapter.display_friend_profile;

import interface_adapter.display_common_profile.DisplayCommonProfileState;

public class DisplayFriendProfileState {
    private String username = "";


    public DisplayFriendProfileState(DisplayFriendProfileState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public DisplayFriendProfileState() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
