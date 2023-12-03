package use_case.send_request;

import entity.User;
import java.util.ArrayList;

public interface SendRequestUserDataAccessInterface {

    /**
     * Returns whether the sender has previously requested the receiver.
     * @param sender The user who wants to send the friend request
     * @param receiver The user who is being requested
     * @return True if previously requested (False otherwise)
     */
    boolean isRequested(User sender, User receiver);

    /**
<<<<<<< HEAD
     * Sends a friend request from one user to another
     * @param sender The user who is sending the friend request
     * @param receiver The user who is receiving the friend request
=======
     * Sends a friend request by adding the sender's username into the receiver's list of friend requests.
     * @param sender
     * @param receiver
     * @return the receiver's friend requests
>>>>>>> main
     */
    ArrayList<String> sendFriendRequest(User sender, User receiver);
    User get(String username);
    void editFile(String Username, String column, String newValue);
}