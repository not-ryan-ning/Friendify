package data_access;

import entity.User;
import use_case.accept_request.AcceptRequestFileUserDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class MockFileUserDataAccessObject implements AcceptRequestFileUserDataAccessInterface {
    private final Map<String, User> accounts = new HashMap<>();

    @Override
    // Testing AcceptRequest
    // Update accounts HashMap (similar in Real DAO) with new User information
    // Return accounts to check that User is correctly updated
    public void updateUserInformation(User user) {
        accounts.remove(user.getUsername());
        accounts.put(user.getUsername(), user);
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
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
