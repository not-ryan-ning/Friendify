package use_case.display_profile;

import entity.Profile;

public class DisplayProfileOutputData {
    private Profile commonProfile;
    private Profile friendProfile;

    public DisplayProfileOutputData(Profile commonProfile, Profile friendProfile) {
        this.commonProfile = commonProfile;
        this.friendProfile = friendProfile;
    }

    public Profile getCommonProfile() {
        return commonProfile;
    }
    public Profile getFriendProfile() {
        return friendProfile;
    }

}
