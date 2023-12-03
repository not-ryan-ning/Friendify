package interface_adapter.display_common_profile;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Represents the state and behavior related to displaying a common profile view
 */
public class DisplayCommonProfileViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Common Profile View";
    public static final String USERNAME_LABEL = "Username: ";
    public static final String BIO_LABEL = "Bio: ";
    public static final String TOP_THREE_ARTISTS_LABEL = "Top Three Artists: ";
    public static final String SPOTIFY_HANDLE = "Spotify Handle: ";

    private DisplayCommonProfileState state = new DisplayCommonProfileState();

    public DisplayCommonProfileViewModel() {
        super("display common profile");
    }

    public void setState(DisplayCommonProfileState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("displayCommonProfileState", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public DisplayCommonProfileState getState() {
        return state;
    }
}
