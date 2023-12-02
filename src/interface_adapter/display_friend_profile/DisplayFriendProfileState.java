package interface_adapter.display_friend_profile;

import entity.Profile;
import interface_adapter.display_common_profile.DisplayCommonProfileState;

public class DisplayFriendProfileState {
    private Profile friendProfile;
    private String username;

    /**
     * Constructs a new DisplayFriendProfileState instance by copying the state from another instance.
     *
     * @param copy The DisplayFriendProfileState to copy from.
     */
    public DisplayFriendProfileState(DisplayFriendProfileState copy) {
        this.friendProfile = copy.friendProfile;
        this.username = copy.username;
    }

    /**
     * Constructs a new DisplayFriendProfileState instance
     */
    public DisplayFriendProfileState() {}

    /**
     * Gets the friend profile associated with this state.
     *
     * @return The friend profile.
     */
    public Profile getFriendProfile() {
        return friendProfile;
    }

    public void setFriendProfile(Profile friendProfile) {
        this.friendProfile = friendProfile;
    }

    /**
     * Gets the username associated with this state.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }
}
