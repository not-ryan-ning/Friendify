package use_case.logout;

import entity.User;

public interface LogoutUserDataAccessInterface {
    User get(String username);
}
