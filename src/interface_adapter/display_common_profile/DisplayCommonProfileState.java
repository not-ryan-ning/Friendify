package interface_adapter.display_common_profile;

import entity.Profile;
import interface_adapter.display_friend_profile.DisplayFriendProfileState;
import interface_adapter.display_profile.DisplayProfileState;

public class DisplayCommonProfileState {
    private Profile commonProfile;


    public DisplayCommonProfileState(DisplayCommonProfileState copy) {
        this.commonProfile = copy.commonProfile;

    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public DisplayCommonProfileState() {}

    public Profile getCommonProfile() {
        return commonProfile;
    }

    public void setCommonProfile(Profile commonProfile) {
        this.commonProfile = commonProfile;
    }
}