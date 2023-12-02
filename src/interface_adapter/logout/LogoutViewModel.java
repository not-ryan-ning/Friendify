package interface_adapter.logout;

import interface_adapter.ViewModel;
import interface_adapter.logout.LogoutState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LogoutViewModel extends ViewModel {
   public final String TITLE_LABEL = "Log Out View";
    public static final String LOGOUT_BUTTON_LABEL = "Log out";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private LogoutState state = new LogoutState();

    public LogoutViewModel() {
        super("log out");
    }

    public void setState(LogoutState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("logOutState", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LogoutState getState() {
        return state;
    }
}


