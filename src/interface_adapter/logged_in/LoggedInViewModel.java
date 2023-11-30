package interface_adapter.logged_in;

import entity.User;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoggedInViewModel extends ViewModel {
    public final String TITLE_LABEL = "Logged In View";

    private LoggedInState state = new LoggedInState();

    public static final String LOGOUT_BUTTON_LABEL = "Log out";
    public static final String REQUESTS_BUTTON_LABEL = "Requests";
    public static final String FRIENDS_BUTTON_LABEL = "Friends";
    public static final String MATCH_BUTTON_LABEL = "Match";
    public static final String EDIT_PROFILE_BUTTON_LABEL = "Edit Profile";

    private User loggedInUser;

    public LoggedInViewModel() {
        super("logged in");
    }

    public void setState(LoggedInState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Login Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("loggedInState", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LoggedInState getState() {
        return state;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
