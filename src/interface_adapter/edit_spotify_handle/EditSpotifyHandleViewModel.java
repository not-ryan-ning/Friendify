package interface_adapter.edit_spotify_handle;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditSpotifyHandleViewModel extends ViewModel {
    public static final String SPOTIFY_HANDLE_LABEL = "Type Spotify Handle";
    public static final String SAVE_SPOTIFY_HANDLE_LABEL = "Save Spotify Handle";
    private EditSpotifyHandleState state = new EditSpotifyHandleState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public EditSpotifyHandleState getState() {
        return state;
    }
    public EditSpotifyHandleViewModel() {
        super("edit spotify handle");
    }
    public void setState(EditSpotifyHandleState state) {
        this.state = state;
    }
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}