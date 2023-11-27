package interface_adapter.edit_profile;

public class EditProfileState {
    private String username = "";
    public EditProfileState(EditProfileState copy) {
        username = copy.username;
    }

    public EditProfileState() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
