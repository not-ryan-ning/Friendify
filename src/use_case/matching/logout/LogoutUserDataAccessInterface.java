package use_case.matching.logout;

import entity.User;

public interface LogoutUserDataAccessInterface {
    User get(String username);
}
