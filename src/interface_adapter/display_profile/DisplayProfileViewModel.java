package interface_adapter.display_profile;

import interface_adapter.ViewModel;
import interface_adapter.display_profile.DisplayProfileState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DisplayProfileViewModel extends ViewModel {

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