package interface_adapter.accept_request;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AcceptRequestViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Display Requests View";
    public static final String VIEW_BUTTON_LABEL = "View Profile";
    public static final String ACCEPT_BUTTON_LABEL = "Accept Request";
    private AcceptRequestState state = new AcceptRequestState();
    public AcceptRequestViewModel() {
        super("display requests");
    }
    public void setState(AcceptRequestState newState) { this.state = newState; }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("acceptRequestsState", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public AcceptRequestState getState() {
        return state;
    }
}
