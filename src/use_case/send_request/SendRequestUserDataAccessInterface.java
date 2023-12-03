package use_case.send_request;

import entity.User;
import java.util.ArrayList;

public interface SendRequestUserDataAccessInterface {

    /**
     * Checks for the sender's username in the receiver's list of friend requests, and returns
     * whether the sender has previously requested the receiver.
     * @param sender
     * @param receiver
     * @return true if previously requested (false otherwise)
     */
    boolean isRequested(User sender, User receiver);

    /**
     * Sends a friend request by adding the sender's username into the receiver's list of friend requests.
     * @param sender
     * @param receiver
     * @return the receiver's friend requests
     */
    ArrayList<String> sendFriendRequest(User sender, User receiver);
    User get(String username);
    void editFile(String Username, String column, String newValue);
}