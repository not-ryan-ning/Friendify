package interface_adapter.logout;

public class LogoutState {
    private String loggedoutUser = "";

    public LogoutState(LogoutState copy) {
        this.loggedoutUser = copy.loggedoutUser;
    }
    public LogoutState() {}

    public String getLoggedoutUser() {
        return loggedoutUser;
    }

    public void setLoggedOutUsers(String username) {
        this.loggedoutUser = username;
    }

}
