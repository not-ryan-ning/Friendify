package use_case.accept_request;

import entity.User;

import java.util.ArrayList;

public interface AcceptRequestUserDataAccessInterface {
    void editFile(String Username, String column, String newValue);
    ArrayList<String> acceptFriendRequest(User currentUser, User acceptedUser);
    ArrayList<String> updateCurrentUserFriends(User currentUser, User acceptedUser);
    ArrayList<String> updateAcceptedUserFriends(User currentUser, User acceptedUser);
    User get(String currentUsername);
    boolean isFriend(User accepter, User sender);
}
