package use_case.accept_request;

import entity.User;

public interface AcceptRequestInputBoundary {
    void updateUserInformation(User user);

    User get(String currentUsername);
}
