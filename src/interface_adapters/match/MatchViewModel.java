package interface_adapters.matching;

import interface_adapters.ViewModel;

import java.beans.PropertyChangeListener;

public class MatchingViewModel extends ViewModel {
    private MatchingState matchingState = new matchingState();

    public MatchingViewModel() {
        super("matching")
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    public
}
