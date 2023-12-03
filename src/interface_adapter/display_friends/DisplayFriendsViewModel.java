package interface_adapter.display_friends;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class  DisplayFriendsViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Display Friends View";
    public static final String VIEW_BUTTON_LABEL = "View Profile";
    private DisplayFriendsState state = new DisplayFriendsState();
    public DisplayFriendsViewModel() { super("display friends"); }
    public void setState(DisplayFriendsState state) { this.state = state; }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("displayFriendsState", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public DisplayFriendsState getState() { return state;}

}
