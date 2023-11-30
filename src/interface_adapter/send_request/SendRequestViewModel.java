package interface_adapter.send_request;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SendRequestViewModel extends ViewModel {
    private SendRequestState sendRequestState = new SendRequestState();

    public SendRequestViewModel() { super("send request"); }

    public void setState(SendRequestState state) { this.sendRequestState = state; }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("sendRequestState", null, this.sendRequestState);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public SendRequestState getState() { return sendRequestState; }
}
