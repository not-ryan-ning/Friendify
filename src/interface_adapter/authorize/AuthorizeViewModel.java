package interface_adapter.authorize;

import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AuthorizeViewModel extends ViewModel {
    private AuthorizeState state = new AuthorizeState();
    public AuthorizeViewModel() { super("authorize"); }
    public void setState(AuthorizeState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("authorizeState", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public AuthorizeState getState() {
        return state;
    }
}
