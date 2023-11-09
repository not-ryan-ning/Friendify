package interface_adapter.logged_out;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoggedOutViewModel extends ViewModel {
    public final String TITLE_LABEL = "Logged Out View";

    private LoggedOutState state = new LoggedOutState();

    private String loggedOutUser;

    public LoggedOutViewModel() {
        super("logged out");
    }

    public void setState(LoggedOutState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Login Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LoggedOutState getState() {
        return state;
    }


    public String getLoggedOutUser() {
        return loggedOutUser;
    }

    public void setLoggedOutUser(String loggedOutUser) {
        this.loggedOutUser = loggedOutUser;
    }

}
