package interface_adapter.display_requests;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DisplayRequestsViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Display Requests View";
    private DisplayRequestsState state = new DisplayRequestsState();
    public DisplayRequestsViewModel() {
        super("display requests");
    }
    public void setState(DisplayRequestsState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("displayRequestsState", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public DisplayRequestsState getState() {
        return state;
    }
}

