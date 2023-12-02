package interface_adapter.display_profile;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DisplayProfileViewModel extends ViewModel {
    public static String VIEW_BUTTON_LABEL = "Profile";

    private DisplayProfileState state = new DisplayProfileState();

    public DisplayProfileViewModel() { super("display profile");
    }

    public void setState(DisplayProfileState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("displayProfileState", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public DisplayProfileState getState() {
        return state;
    }
}
