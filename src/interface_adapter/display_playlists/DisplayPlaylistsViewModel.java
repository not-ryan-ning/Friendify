package interface_adapter.display_playlists;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DisplayPlaylistsViewModel extends ViewModel {

    public static final String DISPLAY_PLAYLISTS_LABEL = "My Playlists";
    public static final String DISPLAY_PLAYLISTS_BUTTON_LABEL = "Display Playlists";

    private DisplayPlaylistsState state = new DisplayPlaylistsState();

    public DisplayPlaylistsViewModel() { super("display playlists"); }

    public void setState(DisplayPlaylistsState state) { this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("displayPlaylistsState", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public DisplayPlaylistsState getState() { return state; }
}
