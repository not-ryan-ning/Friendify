package interface_adapter.display_requests;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Represents the state and functions related to displaying requests
 */
public class DisplayRequestsViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Display Requests View";
    public static final String VIEW_BUTTON_LABEL = "View Profile";
    public static final String ACCEPT_BUTTON_LABEL = "Accept Request";
    private DisplayRequestsState state = new DisplayRequestsState();
    public DisplayRequestsViewModel() {
        super("show requests");
    }
    public void setState(DisplayRequestsState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public DisplayRequestsState getState() {
        return state;
    }
}

