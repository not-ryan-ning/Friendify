package use_case.accept_request;

import entity.User;

public interface AcceptRequestFileUserDataAccessInterface {
    void updateUserInformation(User user);

    User get(String currentUsername);
}
