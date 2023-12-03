package interface_adapter.edit_profile;

/**
 * Represents the state of editing a user's profile.
 */
public class EditProfileState {
    private String username = "";
    public EditProfileState(EditProfileState copy) {
        username = copy.username;
    }

    public EditProfileState() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
