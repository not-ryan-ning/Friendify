package interface_adapter.authorize;

import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Represents the state and behavior related to the authorization process.
 */
public class AuthorizeViewModel extends ViewModel {
    private AuthorizeState state = new AuthorizeState();
    public AuthorizeViewModel() { super("authorize"); }
    public void setState(AuthorizeState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Notifies property change listeners about a change in the authorization state.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("authorizeState", null, this.state);
    }

    /**
     * Adds a property change listener to the view model.
     *
     * @param listener The PropertyChangeListener to be added.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state of the authorization view model.
     *
     * @return The current AuthorizeState.
     */
    public AuthorizeState getState() {
        return state;
    }
}
