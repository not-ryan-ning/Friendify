package interface_adapter.display_friend_profile;

import entity.Profile;
import interface_adapter.display_common_profile.DisplayCommonProfileState;

public class DisplayFriendProfileState {
    private Profile friendProfile;


    public DisplayFriendProfileState(DisplayFriendProfileState copy) {
        this.friendProfile = copy.friendProfile;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public DisplayFriendProfileState() {}

    public Profile getFriendProfile() {
        return friendProfile;
    }

    public void setFriendProfile(Profile friendProfile) {
        this.friendProfile = friendProfile;
    }
}
