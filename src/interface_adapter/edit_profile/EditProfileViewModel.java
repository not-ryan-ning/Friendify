package interface_adapter.edit_profile;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditProfileViewModel extends ViewModel {
    private EditProfileState state = new EditProfileState();
    public EditProfileViewModel() {
        super("editProfile");
    }
    public void setState(EditProfileState editProfileState) {
        this.state = editProfileState;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {

        support.firePropertyChange("editProfileState", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public EditProfileState getState() {
        return state;
    }
}
