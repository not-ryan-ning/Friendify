package interface_adapter.edit_profile;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditProfileViewModel extends ViewModel {
    private EditProfileState editProfileState = new EditProfileState();
    public EditProfileViewModel() {
        super("editProfile");
    }
    public void setState(EditProfileState editProfileState) {
        this.editProfileState = editProfileState;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {

        support.firePropertyChange("editProfileState", null, this.editProfileState);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public EditProfileState getState() {
        return editProfileState;
    }
}
