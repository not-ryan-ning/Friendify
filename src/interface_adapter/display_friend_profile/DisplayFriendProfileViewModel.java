package interface_adapter.display_common_profile;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import entity.Profile;
import interface_adapter.display_friend_profile.DisplayFriendProfileState;

public class DisplayFriendProfileViewModel extends ViewModel {
    public final String TITLE_LABEL = "Common Profile View";

    private DisplayFriendProfileState state = new DisplayFriendProfileState();

    private Profile friendProfile;

    public DisplayFriendProfileViewModel() {
        super("friend profile");
    }

    public void setState(DisplayFriendProfileState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Login Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("friend_state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public DisplayFriendProfileState getState() {
        return state;
    }


    public Profile getFriendProfile() {
        return friendProfile;
    }

    public void setCommonProfile(Profile friendProfile) {
        this.friendProfile = friendProfile;
    }
}
