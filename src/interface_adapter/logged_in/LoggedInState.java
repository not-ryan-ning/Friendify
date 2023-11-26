package interface_adapters.logged_in;

import entity.User;

public class LoggedInState {
    private User user;

    public LoggedInState(LoggedInState copy) {
        user = copy.user;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {}

    public User getCurrentUser() {
        return user;
    }

    public void setCurrentUser(User currentUser) {
        this.user = currentUser;
    }

}
