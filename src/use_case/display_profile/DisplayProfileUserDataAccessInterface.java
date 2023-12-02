package use_case.display_profile;

import entity.User;

import java.util.ArrayList;

public interface DisplayProfileUserDataAccessInterface {
    User get(String username);
    boolean isFriend(String user1, String user2);
}
