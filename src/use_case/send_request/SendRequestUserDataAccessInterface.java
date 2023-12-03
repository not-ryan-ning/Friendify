package use_case.send_request;

import entity.User;

public interface SendRequestUserDataAccessInterface {

    /**
     * Returns whether the sender has previously requested the receiver.
     * @param sender The user who wants to send the friend request
     * @param receiver The user who is being requested
     * @return True if previously requested (False otherwise)
     */
    boolean isRequested(User sender, User receiver);

    /**
     * Sends a friend request from one user to another
     * @param sender The user who is sending the friend request
     * @param receiver The user who is receiving the friend request
     */
    void sendFriendRequest(User sender, User receiver);
    User get(String username);
}
