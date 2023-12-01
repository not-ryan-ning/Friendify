package interface_adapter.display_common_profile;

import entity.Profile;
import interface_adapter.display_friend_profile.DisplayFriendProfileState;
import interface_adapter.display_profile.DisplayProfileState;

public class DisplayCommonProfileState {
    private Profile commonProfile;
    private String username;

    public DisplayCommonProfileState(DisplayCommonProfileState copy) {
        this.commonProfile = copy.commonProfile;
        this.username = copy.username;

    }

    public DisplayCommonProfileState() {}

    public Profile getCommonProfile() {
        return commonProfile;
    }

    public void setCommonProfile(Profile commonProfile) {
        this.commonProfile = commonProfile;
    }

    public String getUsername() {
        return username;
    }
}