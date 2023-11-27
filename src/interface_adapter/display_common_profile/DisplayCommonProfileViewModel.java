package interface_adapter.display_common_profile;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import entity.Profile;

public class DisplayCommonProfileViewModel extends ViewModel {
    public final String TITLE_LABEL = "Common Profile View";

    private DisplayCommonProfileState state = new DisplayCommonProfileState();

    private Profile commonProfile;

    public DisplayCommonProfileViewModel() {
        super("common profile");
    }

    public void setState(DisplayCommonProfileState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Login Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("common_state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public DisplayCommonProfileState getState() {
        return state;
    }


    public Profile getCommonProfile() {
        return commonProfile;
    }

    public void setCommonProfile(Profile commonProfile) {
        this.commonProfile = commonProfile;
    }
}