package interface_adapter.logged_in;

import entity.User;

public class LoggedInState {
    private User user;

    public LoggedInState(LoggedInState copy) {
        user = copy.user;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
