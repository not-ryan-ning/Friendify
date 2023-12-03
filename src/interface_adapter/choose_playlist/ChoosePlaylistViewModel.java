package interface_adapter.choose_playlist;

import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


/**
 * Represents the state and behavior related to choosing a playlist
 */
public class ChoosePlaylistViewModel extends ViewModel {
    public final static String SAVE_PLAYLIST_BUTTON_LABEL = "Save Playlist";

    private ChoosePlaylistState state = new ChoosePlaylistState();

    public ChoosePlaylistViewModel() { super("edit profile"); }

    public void setState(ChoosePlaylistState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies property change listeners about a change in the choose playlist state.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("choosePlaylistState", null, this.state);
    }

    /**
     * Adds a property change listener to the view model.
     *
     * @param listener The PropertyChangeListener to be added.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ChoosePlaylistState getState() {
        return state;
    }
}
