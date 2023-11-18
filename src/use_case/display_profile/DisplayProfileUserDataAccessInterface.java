package use_case.display_profile;

import entity.User;

import java.util.ArrayList;

public interface DisplayProfileUserDataAccessInterface {
    User get(String username);

    ArrayList<String> getFriends(String username);
}
