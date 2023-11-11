package use_case.send_request;

import entity.User;

public interface SendRequestUserDataAccessInterface {
    boolean isFriend(String senderUsername, String receiverUsername);
    void sendFriendRequest(User sender, User receiver);
    User get(String username);
}
