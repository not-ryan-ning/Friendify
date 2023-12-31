package interface_adapter.accept_request;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Represents the state and behavior related to accepting a request.
 */
public class AcceptRequestViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Display Requests View";
    public static final String ACCEPT_BUTTON_LABEL = "Accept Request";
    private AcceptRequestState state = new AcceptRequestState();
    public AcceptRequestViewModel() {
        super("display requests");
    }
    public void setState(AcceptRequestState newState) { this.state = newState; }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("acceptRequestState", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public AcceptRequestState getState() {
        return state;
    }
}
