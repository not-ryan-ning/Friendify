package interface_adapter.edit_bio;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditBioViewModel extends ViewModel {

    public static final String BIO_LABEL = "Type Bio";
    public static final String SAVE_BIO_BUTTON_LABEL = "Save Bio";
    private EditBioState state = new EditBioState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public EditBioState getState() {
        return state;
    }
    public EditBioViewModel() {
        super("edit profile");
    }
    public void setState(EditBioState state) {
        this.state = state;
    }
    public void firePropertyChanged() {
        support.firePropertyChange("editBioState", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}