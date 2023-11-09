package interface_adapter.logged_out;

public class LoggedOutState {
    private String username = "";

    public LoggedOutState(LoggedOutState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedOutState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}

