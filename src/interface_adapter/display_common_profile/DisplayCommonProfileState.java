package interface_adapter.display_common_profile;

public class DisplayCommonProfileState {
    private String username = "";


    public DisplayCommonProfileState(DisplayCommonProfileState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public DisplayCommonProfileState() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
