package interface_adapter.display_friend_profile;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DisplayFriendProfileViewModel extends ViewModel {
    public final String TITLE_LABEL = "Common Profile View";
    public static final String USERNAME_LABEL = "Username: ";
    public static final String BIO_LABEL = "Bio: ";
    public static final String TOP_THREE_ARTISTS_LABEL = "Top Three Artists: ";
    public static final String SPOTIFY_HANDLE = "Spotify Handle: ";

    private DisplayFriendProfileState state = new DisplayFriendProfileState();

    public DisplayFriendProfileViewModel() {
        super("friend profile");
    }

    public void setState(DisplayFriendProfileState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("friendProfileState", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public DisplayFriendProfileState getState() {
        return state;
    }
}
