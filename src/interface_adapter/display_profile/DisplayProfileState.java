package interface_adapter.display_profile;
import entity.Profile;

/**
 * Represents the state for displaying profiles, including both a common profile and a friend profile.
 */
public class DisplayProfileState {
    private Profile commonProfile;
    private Profile friendProfile;

    public DisplayProfileState(DisplayProfileState copy) {
        this.commonProfile = copy.commonProfile;
        this.friendProfile = copy.friendProfile;
    }
    public DisplayProfileState() {}

    public Profile getCommonProfile() {
        return this.commonProfile;
    }
    public Profile getFriendProfile() {
        return this.friendProfile;
    }

    public void setCommonProfile(Profile commmonProfile) {
        this.commonProfile = commonProfile;
    }

    public void setFriendProfile(Profile friendProfile) {
        this.commonProfile = commonProfile;
    }
}
