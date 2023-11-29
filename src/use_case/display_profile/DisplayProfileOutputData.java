package use_case.display_profile;

import entity.Profile;

public class DisplayProfileOutputData {
    private Profile profile;

    public DisplayProfileOutputData(Profile profile) {
        this.profile = profile; // profile can either be friendProfile or commonProfile
    }

    public Profile getProfile() {
        return profile;
    }
//    public Profile getFriendProfile() {
//        return friendProfile;
//    }

}
