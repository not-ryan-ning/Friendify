package interface_adapter.display_common_profile;

import entity.Profile;
import interface_adapter.display_friend_profile.DisplayFriendProfileState;
import interface_adapter.display_profile.DisplayProfileState;

public class DisplayCommonProfileState {
    private Profile commonProfile;
    private String username;

    /**
     * Constructs a new DisplayCommonProfileState instance by copying the state from another instance.
     *
     * @param copy The DisplayCommonProfileState to copy from.
     */
    public DisplayCommonProfileState(DisplayCommonProfileState copy) {
        this.commonProfile = copy.commonProfile;
        this.username = copy.username;

    }

    /**
     * Constructs a new DisplayCommonProfileState instance
     */
    public DisplayCommonProfileState() {}

    /**
     * Gets the common profile associated with this state.
     *
     * @return The common profile.
     */
    public Profile getCommonProfile() {
        return commonProfile;
    }

    /**
     * Sets the common profile for this state.
     *
     * @param commonProfile The common profile to set.
     */
    public void setCommonProfile(Profile commonProfile) {
        this.commonProfile = commonProfile;
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