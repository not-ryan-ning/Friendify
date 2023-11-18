package use_case.display_friends;

import entity.User;

public interface DisplayFriendsUserDataAccessInterface {
    User get(String username);
}
