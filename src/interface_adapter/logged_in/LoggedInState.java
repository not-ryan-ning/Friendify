package interface_adapter.logged_in;

import entity.User;

public class LoggedInState {
    private String username;

    public LoggedInState(LoggedInState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String currentUsername) {
        this.username = currentUsername;
    }

}
