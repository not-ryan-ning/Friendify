package data_access.accept_request;

import entity.User;
import use_case.accept_request.AcceptRequestUserDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MockFileUserDataAccessObject implements AcceptRequestUserDataAccessInterface {
    private final Map<String, User> accounts = new HashMap<>();

    @Override
    public void editFile(String Username, String column, String newValue) {

    }

    @Override
    public ArrayList<String> acceptFriendRequest(User currentUser, User acceptedUser) {
        currentUser.getRequests().remove(acceptedUser.getUsername());
        return currentUser.getRequests();
    }

    @Override
    public ArrayList<String> updateCurrentUserFriends(User currentUser, User acceptedUser) {
        currentUser.getFriends().add(acceptedUser.getUsername());
        return currentUser.getFriends();
    }

    @Override
    public ArrayList<String> updateAcceptedUserFriends(User currentUser, User acceptedUser) {
        acceptedUser.getFriends().add(currentUser.getUsername());
        return acceptedUser.getFriends();
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    @Override
    public boolean isFriend(User accepter, User sender) {
        return accepter.getFriends().contains(sender.getUsername()) ||
                sender.getFriends().contains(accepter.getUsername());
    }

    // Return accounts HashMap for testing purposes
    public Map<String, User> getAccounts() {
        return this.accounts;
    }

    // Place users into accounts HashMap for testing purposes
    public void putUser(User user) {
        accounts.put(user.getUsername(), user);
    }
}
