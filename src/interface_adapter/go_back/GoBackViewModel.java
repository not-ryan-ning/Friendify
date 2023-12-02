package interface_adapter.go_back;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GoBackViewModel extends ViewModel {
    public static final String GO_BACK_LABEL = "Go Back to Home Page";
    private GoBackState state = new GoBackState();
    public GoBackViewModel() {
        super("go back");
    }

    public void setState(GoBackState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("goBackState", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public GoBackState getState() {
        return state;
    }
}

