package interface_adapter.display_matches;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DisplayMatchesViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Display Matches View";
    public static final String REQUEST_BUTTON_LABEL = "Send Request";
    private DisplayMatchesState state = new DisplayMatchesState();

    public DisplayMatchesViewModel() {
        super("display matches");
    }
    public DisplayMatchesState getState() {
        return state;
    }
    public void setState(DisplayMatchesState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
