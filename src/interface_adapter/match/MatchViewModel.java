package interface_adapter.match;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MatchViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Matches";
    public static final String REQUEST_BUTTON_LABEL = "Send Request";
    private MatchState state = new MatchState();

    public MatchViewModel() {
        super("display matches");
    }
    public MatchState getState() {
        return state;
    }
    public void setState(MatchState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("matchState", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
