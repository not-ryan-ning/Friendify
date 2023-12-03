package interface_adapter.edit_bio;

/**
 * Represents the state for editing user bio.
 */
public class EditBioState {
    private String bio;

    public EditBioState(EditBioState copy) {
        this.bio = copy.bio;
    }
    public EditBioState(){}
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
}
