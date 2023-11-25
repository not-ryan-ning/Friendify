package interface_adapter.display_requests;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DisplayRequestsViewModel extends ViewModel {


    private DisplayRequestsState state = new DisplayRequestsState();
    public DisplayRequestsViewModel() {
        super("show requests");
    }
    public void setState(DisplayRequestsState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    // This is what the Clear Presenter will call to let the ViewModel know to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public DisplayRequestsState getState() {
        return state;
    }
}

